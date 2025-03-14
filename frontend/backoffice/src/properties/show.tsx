import {
  Show,
  ShowProps,
  useShowContext,
} from "react-admin";
import { Container, Typography, Box, Grid, Chip } from "@mui/material";

const PropertyShow = (props: ShowProps) => {
  return (
    <Show {...props}>
      <ShowView />
    </Show>
  );
};

export const ShowView = () => {
  const { record } = useShowContext();

  if (!record) return null;

  return (
    <Container sx={{ my: 2 }}>
      {/* Banner Image */}
      <Box
        sx={{
          width: "100%",
          height: 300,
          backgroundImage: `url(${record.banner || "/placeholder.jpg"})`,
          backgroundSize: "cover",
          backgroundPosition: "center",
          borderRadius: 2,
        }}
      />

      {/* Property Details */}
      <Grid container spacing={4} sx={{ mt: 3 }}>
        {/* Left Column: Property Info */}
        <Grid item xs={12} md={6}>
          <Typography variant="h4" fontWeight="bold">
            {record.name}
          </Typography>

          {/* Booking Status */}
          <Chip
            label={record.isBooked ? "Booked" : "Available"}
            color={record.isBooked ? "error" : "success"}
            sx={{ fontSize: 16, fontWeight: "bold", mt: 1 }}
          />

          <Typography variant="body1" color="text.secondary" sx={{ mt: 1 }}>
            {record.description}
          </Typography>

          <Typography variant="h6" sx={{ mt: 2 }}>
            Price: <strong>${record.price}</strong>
          </Typography>

          <Typography variant="h6">
            Location: <strong>{record.location}</strong>
          </Typography>

          <Typography variant="h6">
            Amenities: {record.amenities?.join(", ") || "N/A"}
          </Typography>
        </Grid>

        {/* Right Column: Additional Images */}
        <Grid item xs={12} md={6}>
          <Typography variant="h6" fontWeight="bold">
            Gallery
          </Typography>
          <Box
            sx={{
              display: "grid",
              gridTemplateColumns: "repeat(auto-fill, minmax(150px, 1fr))",
              gap: 2,
              mt: 1,
            }}
          >
            {record.images?.length > 0 ? (
              record.images.map((img: string, index: number) => (
                <Box
                  key={index}
                  sx={{
                    width: "100%",
                    height: 120,
                    backgroundImage: `url(${img})`,
                    backgroundSize: "cover",
                    backgroundPosition: "center",
                    borderRadius: 2,
                  }}
                />
              ))
            ) : (
              <Typography>No images available</Typography>
            )}
          </Box>
        </Grid>
      </Grid>
    </Container>
  );
};

export default PropertyShow;
