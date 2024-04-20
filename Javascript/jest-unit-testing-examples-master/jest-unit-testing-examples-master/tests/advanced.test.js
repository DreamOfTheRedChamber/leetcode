// Note: Sut means System Under Test,
// which saves us from having to give it a unique name each time
import Sut from '../src/advanced';

// A bunch of mock objects to help simulate a window.fetch request and response
const mockGitHubData = { 'feeds_url': 'https://api.github.com/feeds' };

const mockFetchResponse = Promise.resolve(
  {
    json: () => (mockGitHubData)
  }
);

const mockFetch = {
  fetch: () => Promise.resolve(mockFetchResponse)
}

// A mock of the property this.data from the class Advanced
const data = {};

test('ensure the class has been setup properly', () => {
  const sut = new Sut(mockFetch.fetch); // New instance of the class, keeping this test independent
  expect(sut).toEqual({ 'ajax': mockFetch.fetch, data });
});

test('ensure that when the getData function is called, data comes back as a response', () => {
  const sut = new Sut(mockFetch.fetch); // New instance of the class, keeping this test independent
  const spy = jest.spyOn(sut, 'getData'); // Let's spy on the getData method, to see when it gets called

  expect(sut.data).toEqual(data); // Initially no data

  sut.getData().then((data) => {
    expect(spy).toHaveBeenCalledTimes(1); // Make sure it's only called once
    expect(sut.data).toEqual(mockGitHubData); // Now there's data
  });
});