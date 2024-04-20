const { OrderedMap } = require('js-sdsl');
const {IntensitySegments} = require('./IntensitySegments.js');

describe('add() operation', () =>
{
    test('First provided example"', () =>
    {
        const segments = new IntensitySegments();
        expect(segments.toString()).toBe("[]");

        segments.add(10, 30, 1);
        expect(segments.toString()).toBe("[[10,1],[30,0]]")

        segments.add(20, 40, 1);
        expect(segments.toString()).toBe("[[10,1],[20,2],[30,1],[40,0]]")

        segments.add(10, 40, -2);
        expect(segments.toString()).toBe("[[10,-1],[20,0],[30,-1],[40,0]]")
    });

    test('Second provided example"', () =>
    {
        const segments= new IntensitySegments();
        expect(segments.toString()).toBe("[]");

        segments.add(10, 30, 1);
        expect(segments.toString()).toBe("[[10,1],[30,0]]")

        segments.add(20, 40, 1);
        expect(segments.toString()).toBe("[[10,1],[20,2],[30,1],[40,0]]")

        segments.add(10, 40, -1);
        expect(segments.toString()).toBe("[[20,1],[30,0]]")

        segments.add(10, 40, -1);
        expect(segments.toString()).toBe("[[10,-1],[20,0],[30,-1],[40,0]]")
    });

    test('Add an opposite negative range will erase the original one.', () =>
    {
        const segments= new IntensitySegments();
        expect(segments.toString()).toBe("[]");

        segments.add(0, 30, 0);
        expect(segments.toString()).toBe("[]");

        segments.add(20, 30, 1);
        expect(segments.toString()).toBe("[[20,1],[30,0]]");

        segments.add(20, 30, -1);
        expect(segments.toString()).toBe("[]");
    });

    test('Add an negative range spanning across positive ranges.', () =>
    {
        const segments= new IntensitySegments();
        expect(segments.toString()).toBe("[]");

        segments.add(0, 10, 1);
        expect(segments.toString()).toBe("[[0,1],[10,0]]");

        segments.add(20, 30, 1);
        expect(segments.toString()).toBe("[[0,1],[10,0],[20,1],[30,0]]");

        segments.add(-3, 25, -1);
        expect(segments.toString()).toBe("[[-3,-1],[0,0],[10,-1],[20,0],[25,1],[30,0]]");
    });

    test('The redundant zeros in the beginning, middle and end should be trimmed.', () =>
    {
        const segments= new IntensitySegments();
        expect(segments.toString()).toBe("[]");

        segments.add(0, 10, 1);
        expect(segments.toString()).toBe("[[0,1],[10,0]]");

        segments.add(0, 2, -1);
        expect(segments.toString()).toBe("[[2,1],[10,0]]");

        segments.add(8, 10, -1);
        expect(segments.toString()).toBe("[[2,1],[8,0]]");

        segments.add(5, 7, -1);
        expect(segments.toString()).toBe("[[2,1],[5,0],[7,1],[8,0]]");
    });

});

describe('set() operation', () =>
{
    /*
    test('set to zero should not cause differences in segments whose values are zero.', () =>
    {
        const segments = new IntensitySegments();
        expect(segments.toString()).toBe("[]");

        segments.set(10, 30, 1);
        expect(segments.toString()).toBe("[[10,1],[30,0]]")

        segments.set(0, 5, 0);
        expect(segments.toString()).toBe("[[10,1],[30,0]]")

        segments.set(30, 50, 0);
        expect(segments.toString()).toBe("[[10,1],[30,0]]")
    });

    test('set to zero in the segment middle.', () =>
    {
        const segments = new IntensitySegments();
        expect(segments.toString()).toBe("[]");

        segments.set(10, 30, 1);
        expect(segments.toString()).toBe("[[10,1],[30,0]]")

        segments.set(11, 12, 0);
        expect(segments.toString()).toBe("[[10,1],[11,0],[12,1],[30,0]]")
    });

    test('set to negative entries in the segment middle.', () =>
    {
        const segments = new IntensitySegments();
        expect(segments.toString()).toBe("[]");

        segments.set(10, 30, 1);
        expect(segments.toString()).toBe("[[10,1],[30,0]]")

        segments.set(11, 12, -1);
        expect(segments.toString()).toBe("[[10,1],[11,-1],[12,1],[30,0]]")
    });
     */
});

