//Copyright Thomas Shijie Zhang. All Rights Reserved.

import {OrderedMap} from "js-sdsl";

/**
 *
 * IntensitySegments provides the implementation for manages “intensity” by segments. Segments are intervals from -infinity to infinity. Intensities are updated by an integer amount for a given range. All intensity starts with 0.
 *
 * The implementation is based on a sorted hashmap implementation from package js-sdsl https://github.com/js-sdsl/js-sdsl. The sorted hashmap implementation is based on red-black tree and could guarantee O(n) time complexity for
 * insert, update, delete and search operations.
 *
 * The asymptotic running time for important operations are below:
 * <pre>
 *   Method                 big-O
 * ----------------------------------------------------------------------------
 * - add                    O(m log(n)) m is the number of entries in [from, to]
 * - set                    O(m log(n)) m is the number of entries in [from, to]
 * - toString               O(n)
 * </pre>
 */
export class IntensitySegments
{
    /**
     * @description Constructor for intensity segments.
     * @constructor
     * @public
     */
    constructor()
    {
        // The intensive segments are represented by a sorted hashmap inside memory. 
        // More specifically, if you imagine a sweep line from -inf to inf, each time there is a changing intensity, there will be a (key, value) pair inside the sorted hashmap. 
        this.skyline = new OrderedMap();
    }

    /**
     * @description Add amount to segment [from, to).
     * @param from the starting point of the changed segments (inclusive).
     * @param to the ending point of the changed segments (exclusive). Integer value.
     * @param amount the amount of the changed segments.
     * @public
     */
    add(from, to, amount)
    {
        if (!Number.isInteger(from) || !Number.isInteger(to) || !Number.isInteger(amount))
        {
            throw new Error("At least one of input arguments is not a number");
        }

        let [prevKey, prevValue] = this.handleFrom(from, amount, true);

        [prevKey, prevValue] = this.handleBetween(from, to, amount, true, prevKey, prevValue);

        this.handleTo(to, amount, prevValue);

        this.cleanSkyline();
    }

    /**
     * @description Set the segment [from, to) to value amount.
     * @param from the starting point of the changed segments (inclusive).
     * @param to the ending point of the changed segments (exclusive).
     * @param amount the amount of the changed segments.
     * @public
     */
    set(from, to, amount)
    {
        if (!Number.isInteger(from) || !Number.isInteger(to) || !Number.isInteger(amount))
        {
            throw new Error("At least one of input arguments is not a number");
        }

        let [prevKey, prevValue] = this.handleFrom(from, amount, false);

        [prevKey, prevValue] = this.handleBetween(from, to, amount, false, prevKey, prevValue);

        this.handleTo(to, amount, prevValue)

        this.cleanSkyline();
    }

    /**
     * @description Returns the serialized version of intensity segments.
     * @returns {string} The serialized result.
     * @public
     */
    toString()
    {
        const LEFT_BRACKET = '[';
        const RIGHT_BRACKET = ']';
        const COMMA = ',';

        let result = '';
        for (let it = this.skyline.begin(); !it.equals(this.skyline.end()); it.next())
        {
            let [key, value] = it.pointer;
            let segment = LEFT_BRACKET + key + COMMA + value + RIGHT_BRACKET + COMMA;
            result += segment;
        }

        if (result.length > 1)
        {
            result = result.slice(0, result.length - 1)
        }

        return LEFT_BRACKET + result + RIGHT_BRACKET;
    }

    /**
     * @description Helper method to clean the beginning and trailing 0 values.
     * @private
     */
    cleanSkyline()
    {
        // Remove the beginning 0 values
        const keyToRemove = new Set();
        for (let it = this.skyline.begin(); !it.equals(this.skyline.end()); it.next())
        {
            let [key, value] = it.pointer;
            if (value === 0)
            {
                keyToRemove.add(key);
            }
            else
            {
                break;
            }
        }

        // Remove the trailing 0 values
        let [prevKey, prevValue] = [undefined, undefined];
        for (let it = this.skyline.begin(); !it.equals(this.skyline.end()); it.next())
        {
            let [key, value] = it.pointer;
            if (value === prevValue)
            {
                keyToRemove.add(key);
            }

            [prevKey, prevValue] = [key, value];
        }

        for (const key of keyToRemove)
        {
            this.skyline.eraseElementByKey(key);
        }
    }

    /**
     * @description Helper method to handle intensity at point "from"
     * @param from the starting point of the changed segments (inclusive).
     * @param amount the amount of the changed segments.
     * @param isAdd whether it is add() or set() operation
     * @returns {*[]} the [prevKey, prevValue] pair representing the last intensity whose value might impact the next segment point.
     * @private
     */
    handleFrom(from, amount, isAdd)
    {
        // prevValue represents the last intensity whose value might impact the current segment point
        let [prevKey, prevValue] = [undefined, undefined];

        // Handle intensity at point [from, from]
        let lastSmaller = this.skyline.reverseLowerBound(from);
        if (lastSmaller.equals(this.skyline.rEnd()))
        {
            // When "from" is not covered by any segment existing in the sorted hashmap (this.skyline)

            [prevKey, prevValue] = [from, amount];
            this.skyline.setElement(from, amount);
        }
        else
        {
            // When "from" is covered by a segment existing in the sorted hashmap (this.skyline)

            [prevKey, prevValue] = lastSmaller.pointer;
            if (isAdd)
            {
                this.skyline.setElement(from, amount + prevValue);
            }
            else
            {
                this.skyline.setElement(from, amount);
            }
        }

        return [prevKey, prevValue];
    }

    /**
     * Handle intensity at point "to"
     * @param to the ending point of the changed segments (exclusive).
     * @param amount the amount of the changed segments.
     * @param prevValue the last intensity value whose value might impact the next segment point.     * @private
     * @private
     */
    handleTo(to, amount, prevValue)
    {
        // Handle intensity at point [to, to] .
        // Starting from element which is not smaller than "to".
        let firstBigger = this.skyline.upperBound(to);
        if (firstBigger.equals(this.skyline.end()))
        {
            // When "to" is the last element in the sorted hashmap (this.skyline)

            this.skyline.setElement(to, 0);
        }
        else
        {
            let toExist = this.skyline.find(to);
            if (toExist.equals(this.skyline.end()))
            {
                // when "to" is not the last element in the sorted hashmap (this.skyline)

                this.skyline.setElement(to, prevValue);
            }
        }
    }

    /**
     * Handle intensity between (from, to)
     * @param from the starting point of the changed segments (inclusive)
     * @param to the ending point of the changed segments (exclusive).
     * @param amount the amount of the changed segments.
     * @param isAdd whether it is add() or set() operation
     * @param prevKey the last intensity time whose value might impact the next segment point.
     * @param prevValue the last intensity value whose value might impact the next segment point.
     * @private
     */
    handleBetween(from, to, amount, isAdd, prevKey, prevValue)
    {
        for (let iterator = this.skyline.find(from).next(); !iterator.equals(this.skyline.end()) && iterator.pointer[0] < to; iterator.next())
        {
            [prevKey, prevValue] = iterator.pointer;
            if (isAdd)
            {
                this.skyline.setElement(prevKey, amount + prevValue);
            }
            else
            {
                this.skyline.setElement(prevKey, amount);
            }
        }

        return [prevKey, prevValue];
    }
}