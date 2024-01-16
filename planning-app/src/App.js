import './App.css';
import Plans from './components/plans';
import 'bootstrap/dist/css/bootstrap.min.css';
import '@fortawesome/fontawesome-svg-core/styles.css'
import Login from "./components/login"
import React from 'react';

function App() {
  return (
    <React.Fragment>
      <Plans></Plans>
      {/* <Login></Login> */}
    </React.Fragment>
  );
}

export default App;
