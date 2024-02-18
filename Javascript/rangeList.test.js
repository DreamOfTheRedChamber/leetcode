import RangeList from './rangeList';

test('adds 1 + 2 to equal 3', () => {
    let abc = new RangeList();
    abc.add([1,2]);
    abc.add([3,6]);
    abc.add([4,7]);
    abc.print()
});