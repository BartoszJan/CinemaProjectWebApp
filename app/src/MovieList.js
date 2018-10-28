import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import image from './resorces/images/dark_night.jpg';
import './resources/css/App.css';

class MovieList extends Component {

  constructor(props) {
    super(props);
    this.state = {movies: [], isLoading: true};
  }

  componentDidMount() {
    this.setState({isLoading: true});

    fetch('api/movies')
      .then(response => response.json())
      .then(data => this.setState({movies: data, isLoading: false}));
  }

  render() {
    const {movies, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    const movieList = movies.map(movie => {
      const title = `${movie.title}`;
      return <tr key={movie.id}>
        <td style={{whiteSpace: 'nowrap'}}><img src={image} className="movie-image" alt="image" /></td>
        <td>{title}</td>
        <td>
          <ButtonGroup>
            <Button size="sm" color="primary" tag={Link} to={"/movies/" + movie.id}>Go</Button>
          </ButtonGroup>
        </td>
      </tr>
    });

    return (
      <div>
        <Container fluid>
          <h3>Movies</h3>
          <Table className="mt-2">
            <tbody>
            {movieList}
            </tbody>
          </Table>
        </Container>
      </div>
    );
  }
}

export default MovieList;