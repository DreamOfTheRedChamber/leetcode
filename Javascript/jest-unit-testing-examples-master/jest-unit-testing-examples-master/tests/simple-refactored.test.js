// Note: This file is the re-factored version of tests/simple.test.js
// Note: Sut means System Under Test,
// which saves us from having to give it a unique name each time
import Sut from '../src/simple';

// The tests were all repeating the same information, so extracting them out like this,
// is truly practising the pricinple of DRY - Don't Repeat Yourself
// and helps make the test suite more maintainable
const tests = [
  // First check the happy path - the normal inputs expected to get an output
  { inputs: [0, 0], expected: 0 },
  { inputs: [0, 1], expected: 1 },
  { inputs: [1, 1], expected: 2 },
  { inputs: [1000, 1000], expected: 2000 },
  // Now check the sad path - both extreme and strange inputs and what output they should give
  { inputs: [100000000000000000, 100000000000000000], expected: 200000000000000000 },
  { inputs: [false, false], expected: false },
  { inputs: [null, null], expected: false },
  { inputs: [undefined, undefined], expected: false },
  { inputs: [NaN, NaN], expected: false },
  { inputs: [false, false], expected: false },
];

// Using forEach, lets loop over each test configuration, create a new Jest test for each of them,
// and load in the test configuration into that test
tests.forEach((config) => {
  test(`Adding ${config.inputs[0]} and ${config.inputs[1]} should equal ${config.expected}`, () => {
    expect(Sut.apply(this, config.inputs)).toEqual(config.expected);
  });
});