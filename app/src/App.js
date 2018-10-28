import React, { Component } from 'react';
import './resources/css/App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import MovieList from './MovieList';
import MovieDetail from './MovieDetail';

class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path='/' exact={true} component={Home}/>
          <Route path='/movies' exact={true} component={MovieList}/>
          <Route path='/movies/:id' component={MovieDetail}/>
        </Switch>
      </Router>
    )
  }
}

export default App;