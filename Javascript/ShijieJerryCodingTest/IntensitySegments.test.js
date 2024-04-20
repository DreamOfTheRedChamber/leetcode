const { OrderedMap } = require('js-sdsl');
const {IntensitySegments} = require('./IntensitySegments.js');

describe("add() operation", () =>
{
    test('First example"', () =>
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

    test('Second example"', () =>
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
});

describe("set() operation", () =>
{
    test('"', () =>
    {
        const segments = new IntensitySegments();
        expect(segments.toString()).toBe("[]");

        segments.set(10, 30, 1);
        expect(segments.toString()).toBe("[[10,1],[30,0]]")

        segments.set(20, 40, 2);
        expect(segments.toString()).toBe("[[10,1],[20,2],[40,0]]")

        segments.set(30, 50, 0);
        expect(segments.toString()).toBe("[[10,1],[20,2],[30,0]]")
    });
});

