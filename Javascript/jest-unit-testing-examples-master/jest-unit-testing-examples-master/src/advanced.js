const URL = 'https://api.github.com/';

class Advanced {
  // fetch is the dependency window.fetch which is being added into the constructor
  // so that it can be swapped out for a mocked response during testing
  constructor(fetch) {
    this.ajax = fetch;
    this.data = {};
  }

  // This function's job is to fetch the data from the const URL
  // and pass it to the renderData function
  getData() {
    return this.ajax(URL)
        .then((response) => response.json())
        .then((data) => this.renderData(data));
  }

  // This function checks to make sure a particular property of data exists
  // and if so, sets the data to the property this.data
  renderData(data) {
    if (data.feeds_url) {
      this.data = data;
    }
  }
}

export default Advanced;