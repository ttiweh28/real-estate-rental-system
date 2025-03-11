"use client"

import dynamic from "next/dynamic";
import { NextPage } from "next";

const AdminApp = dynamic(() => import("@/AdminApp"), { ssr: false });

const Home: NextPage = () => <AdminApp />;

export default Home;
