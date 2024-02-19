
class RangeList
 {
     constructor()
     {
         this.ranges = []
     }

     add(toBeInserted)
     {
         if (!Array.isArray(toBeInserted) || toBeInserted.length !== 2 || toBeInserted[0] > toBeInserted[1])
         {
            console.error('Invalid input: input must be an array of size 2. And range start should be less or equal to end.');
            return;
         }

         // handle edge cases
        if (toBeInserted[0] === toBeInserted[1])
        {
            return;
        }

        let newRanges = []
        let currRange = toBeInserted;
        for (let i = 0; i < this.ranges.length; i++)
        {
            if (this.#isOverlapping(currRange, this.ranges[i]))
            {
                currRange = [Math.min(currRange[0], this.ranges[i][0]),
                            Math.max(currRange[1], this.ranges[i][1])];
            }
            else if (currRange[0] > this.ranges[i][1])
            {
                newRanges.push(this.ranges[i]);
            }
            else
            {
                newRanges.push(currRange);
                currRange = this.ranges[i];
            }
        }

        newRanges.push(currRange);
        this.ranges = newRanges;
     }

     remove(toBeRemoved)
     {
        let newRanges = [];
        for (let currRange of this.ranges)
        {
            if (!this.#isOverlapping(currRange, toBeRemoved))
            {
                newRanges.push(currRange);
            }
            else
            {
                if (currRange[0] < toBeRemoved[0])
                {
                    newRanges.push([currRange[0], Math.min(currRange[1], toBeRemoved[0])]);
                }

                if (currRange[1] > toBeRemoved[1])
                {
                    newRanges.push([Math.max(toBeRemoved[1], currRange[0]), currRange[1]]);
                }
            }
        }

        this.ranges = newRanges;
     }

     print()
     {
        let result = ""
        for (let i = 0; i < this.ranges.length; i++)
        {
            result = result.concat(" ",  "["+this.ranges[i][0]+","+this.ranges[i][1]+")");
        }

        console.log(result);
     }

     #isOverlapping(range1, range2)
     {
         return !(range1[1] < range2[0] || range2[1] < range1[0]);
     }
 }

function testRemove(original, toBeRemoved)
{
    let result = new RangeList();
    for (let entry of original)
    {
        result.add(entry);
    }
    result.print();
    result.remove(toBeRemoved);
    result.print();
}

function testAdd(toBeAdded)
{
    let result = new RangeList();
    for (let entry of toBeAdded)
    {
        result.add(entry);
    }
    result.print();
}


// expect: [-1, 3], [6, 9]
testAdd([[1, 2], [-1, 3], [6, 9]]);

// expect: [-1, 9]
testAdd([[-1, 9], [-1, 3], [6, 9]]);

// expect: [1, 2], [3, 9]
testAdd([[1, 2], [3, 9], [10, 10]]);

// expect: [1, 8], [10, 21]
testAdd([[1, 5], [10, 20], [20, 20], [20, 21], [2, 4], [3, 8]]);

// expect: [1, 8], [11, 21]
testRemove([[1, 8], [10, 21]], [10, 11])

// expect: []
testRemove([[1, 8], [10, 21]], [-1, 22])

// expect: [1, 3], [19, 21]
testRemove([[1, 8], [10, 21]], [3, 19])
