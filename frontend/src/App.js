import { BrowserRouter, Routes, Route } from 'react-router-dom';
import './App.css';
import Home from './page/Home';
import Login from './page/Login';
import Signup from './page/Signup';
import Write from './page/Write';

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Routes>
          <Route path="/" element={<Home/>} />
          <Route path="/login" element={<Login/>} />
          <Route path="/Signup" element={<Signup/>} />
          <Route path="/write" element={<Write/>} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
