import React, { Component } from 'react';
import './resources/css/App.css';
import AppNavbar from './AppNavbar';
import MovieList from './MovieList';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';

class Home extends Component {
  render() {
    return (
      <div>
        <AppNavbar/>
        <MovieList/>
      </div>
    );
  }
}

export default Home;