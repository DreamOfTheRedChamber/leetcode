const { OrderedMap } = require('js-sdsl');
const { IntensitySegments } = require('./IntensitySegments.js');

describe('Provided examples in the PDF.', () =>
{
    test('First provided example in PDF.', () =>
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

    test('Second provided example in PDF.', () =>
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

describe('add() operation single interval scenario', () => {
    test('[from, to) is covered by existing interval [a, b).', () => {
        const segments = new IntensitySegments();
        expect(segments.toString()).toBe("[]");

        segments.add(10, 30, 1);
        expect(segments.toString()).toBe("[[10,1],[30,0]]")

        segments.add(11, 15, 2);
        expect(segments.toString()).toBe("[[10,1],[11,3],[15,1],[30,0]]")
    });

    test('[from, to) covers the existing interval [a, b).', () => {
        const segments = new IntensitySegments();
        expect(segments.toString()).toBe("[]");

        segments.add(10, 30, 1);
        expect(segments.toString()).toBe("[[10,1],[30,0]]")

        segments.add(4, 35, 2);
        expect(segments.toString()).toBe("[[4,2],[10,3],[30,2],[35,0]]")
    });

    test('[from, to) intersect with interval [a, b).', () => {
        const segments = new IntensitySegments();
        expect(segments.toString()).toBe("[]");

        segments.add(10, 30, 1);
        expect(segments.toString()).toBe("[[10,1],[30,0]]")

        segments.add(25, 35, 2);
        expect(segments.toString()).toBe("[[10,1],[25,3],[30,2],[35,0]]")
    });

    test('[from, to) endpoints "from" already exists with [a, b).', () => {
        const segments = new IntensitySegments();
        expect(segments.toString()).toBe("[]");

        segments.add(10, 30, 1);
        expect(segments.toString()).toBe("[[10,1],[30,0]]")

        segments.add(10, 11, 2);
        expect(segments.toString()).toBe("[[10,3],[11,1],[30,0]]")

        segments.add(30, 31, 2);
        expect(segments.toString()).toBe("[[10,3],[11,1],[30,2],[31,0]]")
    });

    test('[from, to) endpoints "to" already exists with [a, b).', () => {
        const segments = new IntensitySegments();
        expect(segments.toString()).toBe("[]");

        segments.add(10, 30, 1);
        expect(segments.toString()).toBe("[[10,1],[30,0]]");

        segments.add(8, 10, 1);
        expect(segments.toString()).toBe("[[8,1],[10,1],[30,0]]");

        segments.add(25, 30, 1);
        expect(segments.toString()).toBe("[[8,1],[10,1],[25,2],[30,0]]");
    });

    test('[from, to) is before existing segment [a,b).', () =>
    {
        const segments= new IntensitySegments();
        expect(segments.toString()).toBe("[]");

        segments.add(20, 30, 2);
        expect(segments.toString()).toBe("[[20,2],[30,0]]");

        segments.add(12, 15, 1);
        expect(segments.toString()).toBe("[[12,1],[15,0],[20,2],[30,0]]");
    });

    test('[from, to) is after existing segment [a,b).', () =>
    {
        const segments= new IntensitySegments();
        expect(segments.toString()).toBe("[]");

        segments.add(20, 30, 2);
        expect(segments.toString()).toBe("[[20,2],[30,0]]");

        segments.add(32, 35, 1);
        expect(segments.toString()).toBe("[[20,2],[30,0],[32,1],[35,0]]");
    });
});

describe('add() operation multiple interval scenario', () =>
{
    test('Multiple intervals with same value (non-zero) should be output separately.', () => {
        const segments = new IntensitySegments();
        expect(segments.toString()).toBe("[]");

        segments.add(10, 15, 2);
        expect(segments.toString()).toBe("[[10,2],[15,0]]");

        segments.add(17, 18, 2);
        expect(segments.toString()).toBe("[[10,2],[15,0],[17,2],[18,0]]");

        segments.add(15, 17, 2);
        expect(segments.toString()).toBe("[[10,2],[15,2],[17,2],[18,0]]");
    });

    test('Multiple intervals with same zero values should be output separately.', () =>
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

    test('The redundant zeros in the beginning and end should be trimmed.', () =>
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

        segments.add(4, 5, -1);
        expect(segments.toString()).toBe("[[2,1],[4,0],[5,0],[7,1],[8,0]]");
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
});

describe('set() operation single interval scenario.', () =>
{
    test('[from, to) is covered by existing interval [a, b).', () => {
        const segments = new IntensitySegments();
        expect(segments.toString()).toBe("[]");

        segments.set(10, 30, 1);
        expect(segments.toString()).toBe("[[10,1],[30,0]]")

        segments.set(11, 15, 2);
        expect(segments.toString()).toBe("[[10,1],[11,2],[15,1],[30,0]]")
    });

    test('[from, to) covers the existing interval [a, b).', () => {
        const segments = new IntensitySegments();
        expect(segments.toString()).toBe("[]");

        segments.set(10, 30, 1);
        expect(segments.toString()).toBe("[[10,1],[30,0]]")

        segments.set(4, 35, 2);
        expect(segments.toString()).toBe("[[4,2],[10,2],[30,2],[35,0]]")
    });

    test('[from, to) intersect with interval [a, b).', () => {
        const segments = new IntensitySegments();
        expect(segments.toString()).toBe("[]");

        segments.set(10, 30, 1);
        expect(segments.toString()).toBe("[[10,1],[30,0]]")

        segments.set(25, 35, 2);
        expect(segments.toString()).toBe("[[10,1],[25,2],[30,2],[35,0]]")
    });

    test('[from, to) endpoints "from" already exists with [a, b).', () => {
        const segments = new IntensitySegments();
        expect(segments.toString()).toBe("[]");

        segments.set(10, 30, 1);
        expect(segments.toString()).toBe("[[10,1],[30,0]]")

        segments.set(10, 11, 2);
        expect(segments.toString()).toBe("[[10,2],[11,1],[30,0]]")

        segments.set(30, 31, 2);
        expect(segments.toString()).toBe("[[10,2],[11,1],[30,2],[31,0]]")
    });

    test('[from, to) endpoints "to" already exists with [a, b).', () => {
        const segments = new IntensitySegments();
        expect(segments.toString()).toBe("[]");

        segments.set(10, 30, 1);
        expect(segments.toString()).toBe("[[10,1],[30,0]]");

        segments.set(8, 10, 1);
        expect(segments.toString()).toBe("[[8,1],[10,1],[30,0]]");

        segments.set(25, 30, 1);
        expect(segments.toString()).toBe("[[8,1],[10,1],[25,1],[30,0]]");
    });
});

describe('set() operation multiple interval scenario.', () =>
{
    test('Multiple intervals with same value (non-zero) should be output separately.', () => {
        const segments = new IntensitySegments();
        expect(segments.toString()).toBe("[]");

        segments.set(10, 15, 2);
        expect(segments.toString()).toBe("[[10,2],[15,0]]");

        segments.set(17, 18, 2);
        expect(segments.toString()).toBe("[[10,2],[15,0],[17,2],[18,0]]");

        segments.set(15, 17, 2);
        expect(segments.toString()).toBe("[[10,2],[15,2],[17,2],[18,0]]");
    });

    test('Multiple intervals with same zero values should be output separately.', () =>
    {
        const segments= new IntensitySegments();
        expect(segments.toString()).toBe("[]");

        segments.set(0, 30, 0);
        expect(segments.toString()).toBe("[]");

        segments.set(20, 30, 1);
        expect(segments.toString()).toBe("[[20,1],[30,0]]");

        segments.set(20, 30, 0);
        expect(segments.toString()).toBe("[]");
    });

    test('Set to zero should not cause differences in segments whose values are zero.', () =>
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

    test('Set an segment spanning across multiple existing segments.', () =>
    {
        const segments = new IntensitySegments();
        expect(segments.toString()).toBe("[]");

        segments.set(10, 30, 1);
        expect(segments.toString()).toBe("[[10,1],[30,0]]")

        segments.set(35, 40, 2);
        expect(segments.toString()).toBe("[[10,1],[30,0],[35,2],[40,0]]")

        segments.set(41, 48, 3);
        expect(segments.toString()).toBe("[[10,1],[30,0],[35,2],[40,0],[41,3],[48,0]]")

        segments.set(11, 45, -2);
        expect(segments.toString()).toBe("[[10,1],[11,-2],[30,-2],[35,-2],[40,-2],[41,-2],[45,3],[48,0]]")
    });
});