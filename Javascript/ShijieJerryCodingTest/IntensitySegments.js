//Copyright Thomas Shijie Zhang. All Rights Reserved.

import {OrderedMap} from "js-sdsl";

/**
 *
 * IntensitySegments provides the implementation for intensity segments. The tree
 * maintains a set of values, sorted by their corresponding keys. The key/value pairs can be
 * inserted and deleted efficiently in their sorted order as the tree enforces a logn
 * maximum height. This implementation provides guaranteed log(n) time cost for the
 * <tt>contains</tt>, <tt>insert</tt> and <tt>remove</tt>
 * operations.  Algorithms are adaptations of those in Thomas H. Cormen, Charles E. Leiserson,
 * Ronald L. Rivest, Clifford Stein <I>Introduction to Algorithms, second edition</I>.<p>
 *
 * The assymptotic running time for important operations are below:
 * <pre>
 *   Method                 big-O
 * ----------------------------------------------------------------------------
 * - add                    O(m log(n)) m is the number of entries in [from, to]
 * - clone                  O(n logn)
 * - contains               O(logn)
 * - containsAll            O(m logn) m is the cardinality of the supplied collection
 * - every                  O(n * O(f)) f is the function supplied as argument
 * - filter                 O(n * O(f)) f is the function supplied as argument
 * - forEach                O(n * O(f)) f is the function supplied as argument
 * - get                    O(logn)
 * - getValues              O(n)
 * - insert                 O(logn)
 * - insertAll              O(m logn) m is the cardinality of the supplied collection
 * - map                    O(n * O(f)) f is the function supplied as argument
 * - remove                 O(logn)
 * - removeAll              O(m logn) m is the cardinality of the supplied collection
 * - some                   O(n * O(f)) f is the function supplied as argument
 * - contains               O(n * O(f)) f is the function supplied as argument
 * </pre>
 */
export class IntensitySegments
{
    /**
     * Constructor for intensity segments.
     * @constructor
     * @public
     */
    constructor()
    {
        this.skyline = new OrderedMap();
    }

    /**
     *
     * @param from
     * @param to
     * @param amount
     * @public
     */
    add(from, to, amount)
    {
        let [prevKey, prevValue] = this.handleFrom(from, amount, true);

        [prevKey, prevValue] = this.handleBetween(from, to, amount, true, prevKey, prevValue);

        this.handleTo(to, amount, prevValue)

        this.cleanSkyline();
    }

    /**
     *
     * @param from
     * @param to
     * @param amount
     * @public
     */
    set(from, to, amount)
    {
        let [prevKey, prevValue] = this.handleFrom(from, amount, false);

        [prevKey, prevValue] = this.handleBetween(from, to, amount, false, prevKey, prevValue);

        this.handleTo(to, amount, prevValue)

        this.cleanSkyline();
    }

    /**
     *
     * @returns {string}
     * @private
     */
    toString()
    {
        let result = "[";
        for (let it = this.skyline.begin(); !it.equals(this.skyline.end()); it.next())
        {
            result += "[" + it.pointer[0] + "," + it.pointer[1] + "],"
        }

        if (result.length > 1)
        {
            result = result.slice(0, result.length - 1)
        }

        result += "]"
        return result
    }

    /**
     *
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

        // For multiple neighboring entries with same value, only the 1st one is kept.
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
     * Handle intensity at point "from"
     * @param from the starting point of the changed segments (inclusive).
     * @param amount the amount added to the changed segments.
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
     * @param amount the amount added to the changed segments.
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
            // when "to" is not the last element in the sorted hashmap (this.skyline)

            this.skyline.setElement(to, prevValue);
        }

        this.cleanSkyline();
    }

    /**
     * Handle intensity between (from, to)
     * @param from the starting point of the changed segments (inclusive)
     * @param to the ending point of the changed segments (exclusive).
     * @param amount the amount added to the changed segments.
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