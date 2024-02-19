class Range
{
    constructor(left, right)
    {
        this.left = left;
        this.right = right;
    }
}

class RangeList
 {
     constructor()
     {
         this.ranges = []
     }

     add(range)
     {
        let newRanges = []
        newRanges.push(range)
         this.ranges = newRanges;
     }

     remove(range)
     {

     }

     print()
     {
        for (var i = 0; i < this.ranges.length; i++)
        {
            console.log(this.ranges[i][0]+" "+this.ranges[i][1])
        }
     }
 }

function sum(a, b) {
    return a + b;
}
module.exports = sum;