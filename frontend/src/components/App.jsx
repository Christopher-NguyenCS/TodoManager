import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router';
import AppLayout from './AppLayout';
import Dashboard from './Dashboard';
import Project from './Project';
import TaskGroup from './TaskGroup';
import Task from './Task';

const App = () => {
  return (

      <Routes>
        <Route path="/" element={<AppLayout />}>
          <Route path="dashboard" element={<Dashboard />} />
          <Route path="project/:projectId" element={<Project />}>
            <Route path="taskgroup/:taskGroupId" element={<TaskGroup />} >
              <Route path="task/:taskId" element={<Task />} />
            </Route>
          </Route>
        </Route>
      </Routes>

  );
};

export default App;
