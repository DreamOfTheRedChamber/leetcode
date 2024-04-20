import {OrderedMap} from "js-sdsl";

class IntensitySegments
{
    constructor()
    {
        this.skyline = new OrderedMap();
    }

    add(from, to, amount)
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
            this.skyline.setElement(from, amount + prevValue);
        }

        // Handle all intensity between (from, to)
        // Starting from next element of "from" to bigger elements
        for (let iterator= this.skyline.find(from).next(); !iterator.equals(this.skyline.end()) && iterator.pointer[0] < to; iterator.next())
        {
            [prevKey, prevValue] = iterator.pointer;
            this.skyline.setElement(prevKey, prevValue + amount);
        }

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

    set(from, to, amount)
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
            this.skyline.setElement(from, amount);
        }

        // Handle all intensity between (from, to)
        // Starting from next element of "from" to bigger elements
        for (let iterator= this.skyline.find(from).next(); !iterator.equals(this.skyline.end()) && iterator.pointer[0] < to; iterator.next())
        {
            [prevKey, prevValue] = iterator.pointer;
            this.skyline.setElement(prevKey, amount);
        }

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
        let [prevKey, prevValue] = this.skyline.begin().pointer;
        for (let it = this.skyline.begin().next(); !it.equals(this.skyline.end()); it.next())
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
}

module.exports = {IntensitySegments};