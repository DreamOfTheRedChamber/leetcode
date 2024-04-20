const TYPE_NUMBER = 'number';

export default function add(a, b) {
  // First check if a and b exist (zero is an allowed value), then check their types are correct
  if ((a || a === 0) && (b || b === 0) && typeof(a) === TYPE_NUMBER && typeof(b) === TYPE_NUMBER) {
    return a + b;
  }
  // If there's anything wrong with the input data, return false
  return false;
}