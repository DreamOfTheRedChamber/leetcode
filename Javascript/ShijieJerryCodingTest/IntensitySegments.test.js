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

    test('Third example"', () =>
    {
        /*
        let segments= new OrderedMap();
        segments.setElement(1, 0);
        segments.setElement(3, 2);
        segments.setElement(6, 5);
        segments.setElement(8, 7);
        segments.setElement(11, 10);
        segments.setElement(13, 12);

        let elem = segments.find(6);
        if (!segments.find(6).equals(segments.end()))
        {
            console.log(elem.pointer[0])
            console.log(elem.pointer[1])
        }

        let elem1 = segments.find(5)
        if (!segments.find(5).equals(segments.end()))
        {
            console.log(elem1.pointer[0])
            console.log(elem1.pointer[1])

            console.log(elem1.next().pointer[0])
        }

        let elemNotExist = segments.find(8);
        */
    });
});

