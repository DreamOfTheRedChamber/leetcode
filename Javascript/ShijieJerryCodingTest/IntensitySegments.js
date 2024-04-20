import {OrderedMap} from "js-sdsl";

class IntensitySegments
{
    constructor()
    {
        this.segments = new OrderedMap();
    }

    add(from, to, amount)
    {
        if (!this.segments.find(from))
        {
            this.segments.setElement(from, 0);
        }
        if (!this.segments.find(to))
        {
            this.segments.setElement(to, 0);
        }

        let currNode = this.segments.find(from);
        let currKey = currNode.pointer[0];
        let currValue = currNode.pointer[1];
        while (currKey < to)
        {
            this.segments.setElement(currKey, currValue + amount);
            currNode = currNode.next();
            currKey = currNode.pointer[0];
            currValue = currNode.pointer[1];
        }

        if (currKey === to && currValue === 0 && amount === -1)
        {
            this.segments.eraseElementByKey(to);
        }
    }

    set(from, to, amount)
    {
        if (!this.segments.find(from))
        {
            this.segments.setElement(from, amount);
        }
        if (!this.segments.find(to))
        {
            this.segments.setElement(to, amount);
        }

        let currNode= this.segments.find(from);
        let currKey = currNode.pointer[0];
        let currValue = currNode.pointer[1];
        while (currKey < to)
        {
            this.segments.setElement(currKey, amount);
            currNode = currNode.next();
            currKey = currNode.pointer[0];
            currValue = currNode.pointer[1];
        }
    }

    toString()
    {
        let result = "["
        for (let it = this.segments.begin(); !it.equals(this.segments.end()); it.next())
        {
            result += "[" + it.pointer[0] + "," + it.pointer[1] + "],"
        }

        if (result.length > 1)
        {
            result = result.slice(0, result.length-2)
        }

        result += "]"
        return result
    }
}

module.exports = {IntensitySegments};