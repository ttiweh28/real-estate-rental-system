import React from "react";
import { Card, CardContent } from "@mui/material";
import { FilterList, FilterListItem } from "react-admin";
import AccessTimeIcon from "@mui/icons-material/AccessTime";

export default function Aside() {
  return (
    <Card
      sx={{
        display: {
          xs: "none",
          md: "block",
        },
        order: -1,
        flex: "0 0 15em",
        mr: 2,
        alignSelf: "flex-start",
      }}
    >
      <CardContent sx={{ pt: 1 }}>
        <FilterList label="Filter" icon={<AccessTimeIcon />}>
          <FilterListItem
            label="Open"
            value={{
              status: 'open',
            }}
          />
          <FilterListItem
            label="Booked"
            value={{
               status: 'booked',
            }}
          />
        </FilterList>
      </CardContent>
    </Card>
  );
}
