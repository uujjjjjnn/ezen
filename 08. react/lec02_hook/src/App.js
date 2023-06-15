/* eslint-disable no-unused-vars */
/* eslint-disable react/jsx-pascal-case */
import './App.css';
import Hook01_01useState from './hooks/Hook01_01useState';
import Hook01_02useState from './hooks/Hook01_02useState';
import Hook02_01useEffect from './hooks/Hook02_01useEffect';
import Hook02_02useEffect from './hooks/Hook02_02useEffect';
import Hook03_01useRef from './hooks/Hook03_01useRef';

import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  return (
    <div className="App">
      {/* <Hook01_01useState /> */}
      {/* <Hook01_02useState /> */}
      {/* Hook02_01useEffect /> */}
      {/* Hook02_02useEffect /> */}
      
      <Hook03_01useRef />
    </div>
  );
}

export default App;
