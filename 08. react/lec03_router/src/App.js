import './App.css';
import {Routes, Route } from 'react-router-dom';
import Layout from './Layout';
import Home from './pages/Home';
import About from './pages/About';
import Profile from './pages/Profile';
import Articles from './pages/Articles';
import NotFound from './pages/NotFound';
import MyPage from './pages/MyPage';
import Login from './pages/Login';
import Article from './pages/Article';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path='/' element={<Layout />}>
        <Route path="/" element={<Home />}></Route>
        <Route path="/about" element={<About />}></Route>
        <Route path="/profiles/:username" element={<Profile />}></Route>
        </Route>
        <Route path="/articles" element={<Articles />}>
          <Route path="/articles/:id" element={<Article />} />
          </Route>
        <Route path='/login' element={<Login />} />
        <Route path='/login' element={<MyPage />} />
        <Route path='/*' element={<NotFound />} />
      </Routes>
    </div>
  );
}

export default App;
