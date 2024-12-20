import React from 'react';
import {Routes, Route } from 'react-router';
import AppLayout from './AppLayout';
import Dashboard from './Dashboard';
import Project from './Project';
import TaskGroup from './TaskGroup';
import Task from './Task';

function App() {
  return (

      <Routes>
        <Route path="/" element={<AppLayout />}>
          <Route index element={<Dashboard />}/>
          <Route path="project/:projectId" element={<Project />}>
            <Route path="taskgroup/:taskGroupId" element={<TaskGroup />}>
              <Route path="task/:taskId" element={<Task />} />
            </Route>
          </Route>
        </Route>
      </Routes>

  );
};

export default App;
