import React from "react";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import "./App.css";
import routes from "./configs/routes";

function App() {
  return (
    <BrowserRouter>
      <Switch>
        {routes.map((route, index) => (
          <Route
            key={index}
            path={route.path}
            exact
            render={(props) => <route.component {...props} {...route.props} />}
          />
        ))}
      </Switch>
    </BrowserRouter>
  );
}

export default App;
