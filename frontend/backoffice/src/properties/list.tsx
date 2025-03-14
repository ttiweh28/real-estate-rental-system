import { List, ListProps, useListContext } from "react-admin";
import { Container } from "@mui/material";
import { T_Property } from "@/types/property";
import { PropertyCard } from "@/components/properties/PropertyCard";

const ListProperties = (props: ListProps) => {
  return (
    <List {...props}>
      <CustomPropertyList />
    </List>
  );
};

const CustomPropertyList = () => {
  const { data } = useListContext<T_Property>();

  return (
    <div
      style={{
        padding: "16px",
        paddingBottom: "16px",
        display: "grid",
        gridTemplateColumns: "repeat(auto-fill, minmax(200px, 1fr))",
        gap: "16px",
      }}
    >
      {data?.map((property) => (
        <PropertyCard key={property.id} property={property} />
      ))}
    </div>
  );
};

export default ListProperties;
