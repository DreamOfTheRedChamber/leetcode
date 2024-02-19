
/*
test('adds 1 + 2 to equal 3', () => {
    let abc = new RangeList();
    abc.add([1,2]);
    abc.add([3,6]);
    abc.add([4,7]);
    abc.print()
});
 */

const sum = require('./rangelist');
//import RangeList from './rangelist';

describe("FizzBuzz", () => {
    test('adds 1 + 2 to equal 3', () => {
        expect(sum(1, 2)).toBe(3);
    });

    test('adds 3 + 4 to equal 7', () => {
        expect(sum(3, 4)).toBe(7);
    });

    /*
    test('test rangelist print', () => {
        var abc = new RangeList();
    });
     */
});