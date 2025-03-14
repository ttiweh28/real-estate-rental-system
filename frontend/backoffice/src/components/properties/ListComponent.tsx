import React from "react";
import { Card, CardMedia } from "@mui/material";
import { useRecordContext } from "react-admin";
import { T_Property } from "@/types/property";

export const ListComponent = () => {
  const record = useRecordContext<T_Property>();
  if (!record) return null;
  return (
    <Card sx={{ display: "inline-block" }}>
      <CardMedia
        component="img"
        image={record.banner}
        alt=""
        sx={{ maxWidth: "42em", maxHeight: "15em" }}
      />
    </Card>
  );
};
