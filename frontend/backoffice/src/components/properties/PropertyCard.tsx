import React from "react";
import {
  Card,
  CardContent,
  CardMedia,
  Chip,
  Typography,
  Box,
} from "@mui/material";
import { T_Property } from "@/types/property";
import { useRedirect } from "react-admin";

interface PropertyCardProps {
  property: T_Property;
}

export const PropertyCard: React.FC<PropertyCardProps> = ({ property }) => {
  const redirect = useRedirect();

  return (
    <Card
      onClick={() => redirect("show", "properties", property.id)}
      sx={{
        height: "200px",
        width: "100%",
        position: "relative",
        cursor: "pointer",
        transition: "transform 0.2s ease-in-out",
        "&:hover": {
          transform: "scale(1.02)",
        },
      }}
    >
      <CardMedia
        component="img"
        height="200"
        image={property.banner}
        alt={property.name}
        sx={{
          objectFit: "cover",
          height: "100%",
        }}
      />
      <Box
        sx={{
          position: "absolute",
          top: 0,
          right: 0,
          p: 1,
        }}
      >
        <Chip
          label={property.isBooked ? "Booked" : "Available"}
          color={property.isBooked ? "error" : "success"}
          size="small"
          sx={{
            backgroundColor: property.isBooked
              ? "rgba(211, 47, 47, 0.9)"
              : "rgba(46, 125, 50, 0.9)",
            color: "white",
          }}
        />
      </Box>
      <CardContent
        sx={{
          position: "absolute",
          bottom: 0,
          width: "100%",
          background:
            "linear-gradient(to top, rgba(0,0,0,0.9), rgba(0,0,0,0.7))",
          p: 1,
          "&:last-child": { pb: 1 },
        }}
      >
        <Typography
          variant="subtitle2"
          component="h3"
          sx={{
            color: "white",
            fontWeight: 600,
            overflow: "hidden",
            textOverflow: "ellipsis",
            whiteSpace: "nowrap",
            textShadow: "0px 1px 2px rgba(0,0,0,0.5)",
            fontSize: "0.9rem",
            letterSpacing: "0.25px",
          }}
        >
          {property.name}
        </Typography>
      </CardContent>
    </Card>
  );
};
