import { BrowserRouter, Routes, Route } from 'react-router-dom';
import './App.css';
import Home from './page/Home';
import Login from './page/Login';
import Signup from './page/Signup';

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Routes>
          <Route path="/" element={<Home/>} />
          <Route path="/login" element={<Login/>} />
          <Route path="/Signup" element={<Signup/>} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
