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
            <div class="movies-left">
                <MovieList/>
            </div>
            <div class="showings-right">
                <Container fluid>
                    <h3>Showings</h3>
                </Container>
            </div>
      </div>
    );
  }
}

export default Home;