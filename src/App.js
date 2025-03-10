import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar/Navbar';
import Home from './components/Home/Home';
import User from './components/User/User';

function App() {
  return (
    <div className="App">
      <Router>
      <Navbar></Navbar>
      <Routes>
        <Route exact path='/' Component={Home}></Route>
        <Route exact path='/users/:userId' Component={User}></Route>
      </Routes>
      </Router> 
    </div>
  );
}

export default App;
