import { useRecordContext } from "react-admin";
import { Avatar } from "@mui/material";

export const PropertyOwnerAvatar = ({
  size = "normal",
}: {
  size?: "small" | "normal" | "large";
}) => {
  const record = useRecordContext();
  if (!record) return null;

  const sizeStyles = {
    small: { width: 24, height: 24 },
    normal: { width: 48, height: 48 },
    large: { width: 80, height: 80 },
  };

  return (
    <Avatar
      src={record.avatar}
      sx={{
        borderRadius: "50%",
        ...sizeStyles[size],
      }}
    />
  );
};
