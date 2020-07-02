import React from "react";
import { Link } from "react-router-dom";
import "./styles.css";

function UsagePage() {
  return (
    <>
      <button>
        <Link to="/add">Tambah entry</Link>
      </button>
      <button>
        <Link to="/report">Report</Link>
      </button>
    </>
  );
}

export default UsagePage;
