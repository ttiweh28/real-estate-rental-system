import React from "react";
import { Datagrid, List, TextField } from "react-admin";

export const ListPropertyOwners: React.FC = () => (
  <List>
    <Datagrid>
        <TextField source="username" />
        <TextField source="firstName" />
        <TextField source="lastName" />
    </Datagrid>
  </List>
);
