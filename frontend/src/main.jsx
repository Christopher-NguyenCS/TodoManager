import React from 'react';
import ReactDOM from 'react-dom/client';
import {BrowserRouter,Routes, Route} from "react-router";
import './index.css'
import App from './components/App.jsx'
import AppLayout from './components/AppLayout.jsx';
import Dashboard from './components/Dashboard.jsx';
import Project from './components/Project.jsx';

const root = document.getElementById("root");
ReactDOM.createRoot(root).render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<App/>}>
        <Route element={<AppLayout/>}>
          <Route element={<Dashboard/>}>
              <Route path="project/:projectId" element={<Project/>}>
              </Route>
          </Route>
        </Route>
      </Route>
    </Routes>
  </BrowserRouter>
)
