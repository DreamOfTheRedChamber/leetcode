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
        let iterator = this.skyline.find(from).next();
        while (!iterator.equals(this.skyline.end()))
        {
            let [key, value] = iterator.pointer;
            if ( key >= to )
            {
                break;
            }

            [prevKey, prevValue] = iterator.pointer;
            this.skyline.setElement(key, value + amount);
            iterator = iterator.next();
        }

        if (iterator.equals(this.skyline.end()))
        {
            // When there is no "to" entry in the sorted hashmap (this.skyline)

            this.skyline.setElement(to, 0);
        }
        else
        {
            let [key, value] = iterator.pointer;
            if (iterator.equals(this.skyline.rBegin()) && key === to)
            {
                // when "to" exists as the last element in the sorted hashmap

                this.skyline.setElement(to, 0);
            }
            else
            {
                // when "to" is not the last element in the sorted hashmap

                this.skyline.setElement(to, prevValue);
            }
        }

        this.cleanSkyline();
    }

    set(from, to, amount)
    {
        this.skyline.setElement(from, amount);
        let it = this.skyline.find(from);
        for (; !it.equals(this.skyline.end()); it.next())
        {
            let [key, value] = it.pointer;
            if (key >= to)
            {
                break;
            }

            this.skyline.setElement(key, amount);
        }

        if (it.equals(this.skyline.end()))
        {
            this.skyline.setElement(to, 0);
        }
        else
        {
            this.skyline.setElement(to, amount);
        }

        this.cleanSkyline();
    }

    toString()
    {
        let result = "["
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