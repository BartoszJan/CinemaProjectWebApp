import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';

class MovieDetail extends Component {

  constructor(props) {
      super(props);
      this.state = {movie: {}, isLoading: true};
    }

  async componentDidMount() {
      this.setState({isLoading: true});

          fetch(`/api/movie/${this.props.match.params.id}`)
            .then(response => response.json())
            .then(data => this.setState({movie: data, isLoading: false}));
  }

  render() {
  const {movie, isLoading} = this.state;

      if (isLoading) {
        return <p>Loading...</p>;
      }

    return <div>
                   <AppNavbar/>
                   <Container fluid>
                     <h3>{movie.title}</h3>
                     <Table className="mt-3">
                       <thead>
                       <tr>
                         <th width="20%">Director</th>
                         <th width="20%">Year</th>
                         <th width="10%">Duration</th>
                       </tr>
                       </thead>
                       <tbody>
                       <tr>
                               <td style={{whiteSpace: 'nowrap'}}>{movie.director}</td>
                               <td>{movie.year}</td>
                               <td>{movie.duration}</td>
                             </tr>
                       </tbody>
                     </Table>
                   </Container>
                 </div>
  }
}

export default withRouter(MovieDetail);