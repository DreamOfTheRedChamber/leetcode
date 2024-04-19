const newObject = require('./IntensitySegments.js')

describe("add() operation", () => {
    test('First example"', () => {
        const segments = new newObject.IntensitySegments();
        expect(segments.toString()).toBe("[]");

        segments.add(10, 30, 1);
        expect(segments.toString()).toBe("[[10,1],[30,0]]")

        segments.add(20, 40, 1);
        expect(segments.toString()).toBe("[[10,1],[20,2],[30,1],[40,0]]")

        segments.add(10, 40, -2);
        expect(segments.toString()).toBe("[[10,-1],[20,0],[30,-1],[40,0]]")
    });

    test('Second example"', () => {
        const segments = new newObject.IntensitySegments();
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