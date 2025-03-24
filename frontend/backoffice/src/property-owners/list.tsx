import { PropertyOwnerAvatar } from "@/components/property-owners/OwnerAvatar";
import React from "react";
import { Datagrid, List, TextField } from "react-admin";

export const ListPropertyOwners: React.FC = () => (
  <List>
    <Datagrid>
        <PropertyOwnerAvatar size="normal" />
        <TextField source="firstName" />
        <TextField source="lastName" />
        <TextField source="email" />
        <TextField source="role" />
    </Datagrid>
  </List>
);
