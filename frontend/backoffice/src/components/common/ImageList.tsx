import * as React from "react";
import { Avatar, Box, Paper, Typography } from "@mui/material";
import {
  Link,
  RecordContextProvider,
  useCreatePath,
  useListContext,
  useRecordContext,
} from "react-admin";
import { T_Property } from "@/types/property";


// eslint-disable-next-line @typescript-eslint/no-explicit-any
const times = (nbChildren: number, fn: (key: number) => any) => {
  return Array.from({ length: nbChildren }, (_, key) => fn(key))
}

const LoadingGridList = () => (
  <Box display="flex" flexWrap="wrap" width={1008} gap={1}>
    {times(15, (key) => (
      <Paper
        sx={{
          height: 200,
          width: 194,
          display: "flex",
          flexDirection: "column",
          backgroundColor: "grey[200]",
        }}
        key={key}
      />
    ))}
  </Box>
);

const PropertyCard = (props: { record?: T_Property }) => {
  const record = useRecordContext<T_Property>(props);
  const [elevation, setElevation] = React.useState(1);
  const createPath = useCreatePath();

  if (!record) return null;

  return (
    <Link
      to={createPath({
        resource: "properties",
        id: record.id,
        type: "show",
      })}
      underline="none"
      onMouseEnter={() => setElevation(3)}
      onMouseLeave={() => setElevation(1)}
    >
      <Paper
        sx={{
          height: 200,
          display: "flex",
          flexDirection: "column",
          justifyContent: "space-between",
          padding: "1em",
        }}
        elevation={elevation}
      >
        <Box display="flex" flexDirection="column" alignItems="center">
          <Avatar
            src={record.banner}
            alt={record.name}
            sx={{
              "& img": { objectFit: "contain" },
              "&.MuiAvatar-colorDefault": {
                color: "primary.contrastText",
              },
            }}
          >
            {record.name.charAt(0)}
          </Avatar>
          <Box textAlign="center" marginTop={1}>
            <Typography variant="subtitle2">{record.name}</Typography>
          </Box>
        </Box>
      </Paper>
    </Link>
  );
};

const LoadedGridList = () => {
  const { data, error, isPending } = useListContext<T_Property>();

  if (isPending || error) return null;

  return (
    <Box
      width="100%"
      gap={1}
      display="grid"
      gridTemplateColumns="repeat(auto-fill, minmax(180px, 1fr))"
    >
      {data.map((record) => (
        <RecordContextProvider key={record.id} value={record}>
          <PropertyCard />
        </RecordContextProvider>
      ))}

      {data.length === 0 && <Typography p={2}>No properties found</Typography>}
    </Box>
  );
};

export const ImageList = () => {
  const { isPending } = useListContext();
  return isPending ? <LoadingGridList /> : <LoadedGridList />;
};
