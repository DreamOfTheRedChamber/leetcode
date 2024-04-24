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
        // A list of segments in format (segment start, intensity).
        this.segments = new OrderedMap();

        // Whether the serialization format has changed after the last call of .toString()
        this.serializationChanged = true;

        // The serialization format of the segment lists.
        this.serialization = "";
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

        this.removeRedundantZeros();

        // Since an add() operation is performed, the serialization format mostly has changed.
        this.serializationChanged = true;
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

        this.removeRedundantZeros();

        // Since a set() operation is performed, the serialization format mostly has changed.
        this.serializationChanged = true;
    }

    /**
     * @description Returns the serialized version of intensity segments.
     * @returns {string} The serialized result.
     * @public
     */
    toString()
    {
        if (this.serializationChanged)
        {
            const arr = Array.from(this.segments);
            this.serialization = JSON.stringify(arr);
            this.serializationChanged = false;
            return this.serialization;
        }
        else
        {
            return this.serialization;
        }
    }

    /**
     * @description Helper method to clean the beginning and trailing 0 values.
     * @private
     */
    removeRedundantZeros()
    {
        // Remove the beginning 0 values
        const keyToRemove = new Set();
        for (let it = this.segments.begin(); !it.equals(this.segments.end()); it.next())
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

        // Remove continuous trailing 0 values, only 1 should be left
        let [prevKey, prevValue] = [undefined, undefined];
        for (let it = this.segments.rBegin(); !it.equals(this.segments.rEnd()); it.next())
        {
            let [key, value] = it.pointer;
            if (value !== 0)
            {
                break;
            }
            else
            {
                if (value === prevValue && prevValue === 0)
                {
                    keyToRemove.add(prevKey);
                }

                [prevKey, prevValue] = [key, value];
            }
        }

        for (const key of keyToRemove)
        {
            this.segments.eraseElementByKey(key);
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

        let lastSmaller = this.segments.reverseLowerBound(from);
        if (lastSmaller.equals(this.segments.rEnd()))
        {
            // When "from" is not covered by any segment existing in the sorted hashmap (this.skyline)

            this.segments.setElement(from, amount);
        }
        else
        {
            // When "from" is covered by a segment existing in the sorted hashmap (this.skyline)

            [prevKey, prevValue] = lastSmaller.pointer;
            if (isAdd)
            {
                this.segments.setElement(from, amount + prevValue);
            }
            else
            {
                this.segments.setElement(from, amount);
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
        let toIterator = this.segments.find(to);

        // The value at "to" should not be impacted by add() or set() operation because it is exclusive.
        // Otherwise, set its value to the previous neighboring entry.
        if (toIterator.equals(this.segments.end()))
        {
            if (prevValue === undefined)
            {
                // There is no existing segments covering "to" endpoint
                prevValue = 0;
            }

            this.segments.setElement(to, prevValue);
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
        for (let iterator = this.segments.find(from).next(); !iterator.equals(this.segments.end()) && iterator.pointer[0] < to; iterator.next())
        {
            [prevKey, prevValue] = iterator.pointer;
            if (isAdd)
            {
                this.segments.setElement(prevKey, amount + prevValue);
            }
            else
            {
                this.segments.setElement(prevKey, amount);
            }
        }

        return [prevKey, prevValue];
    }
}