import React, { useEffect } from "react";
import { Link } from "react-router-dom";
import "./styles.css";
import { useDispatch, useSelector } from "react-redux";
import { getUsageReport } from "../../actions/usage";

function UsageReportPage() {
  const dispatch = useDispatch();
  const { data, isLoading, error } = useSelector((state) => state.usages);
  const contraceptions =
    data[0]?.contraceptions.map((item) => item.contraception.name) || [];

  useEffect(() => {
    dispatch(getUsageReport());
  }, [dispatch]);

  return (
    <>
      <button>
        <Link to="/">Kembali</Link>
      </button>
      {isLoading ? (
        "Memuat..."
      ) : error ? (
        "Gagal memuat"
      ) : data.length === 0 ? (
        "Tidak ada data propinsi"
      ) : (
        <table>
          <thead>
            <tr>
              <th rowSpan="2">No</th>
              <th rowSpan="2">Propinsi</th>
              <th colSpan="3">Pemakai Alat Kontrasepsi</th>
              <th rowSpan="2">Jumlah</th>
            </tr>
            <tr>
              {contraceptions.map((contraception) => (
                <th key={contraception}>{contraception}</th>
              ))}
            </tr>
          </thead>
          <tbody>
            {data.map((row, i) => (
              <tr key={row.province.id}>
                <td>{i + 1}</td>
                <td>{row.province.name}</td>
                {row.contraceptions.map((item) => (
                  <td key={item.contraception.id}>{item.count}</td>
                ))}
                <td>{row.count}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </>
  );
}

export default UsageReportPage;
