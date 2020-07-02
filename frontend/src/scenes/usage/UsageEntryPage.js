import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import { useSelector, useDispatch } from "react-redux";
import { getProvinces } from "../../actions/province";
import { getContraceptions } from "../../actions/contraception";
import { addUsage } from "../../actions/usage";
import "./styles.css";

function UsageEntryPage() {
  const dispatch = useDispatch();
  const {
    data: provinces,
    isLoading: isLoadingProvinces,
    error: provincesError,
  } = useSelector((state) => state.provinces);
  const {
    data: contraceptions,
    isLoading: isLoadingContraceptions,
    error: contraceptionsError,
  } = useSelector((state) => state.contraceptions);
  const { isLoading: isSaving, message: saveMessage } = useSelector(
    (state) => state.usage
  );
  const [provinceId, setProvinceId] = useState("");
  const [contraceptionId, setContraceptionId] = useState("");
  const [usageCount, setUsageCount] = useState(0);

  const submit = () => {
    dispatch(
      addUsage({
        provinceId,
        contraceptionId,
        usageCount,
      })
    );
  };

  const findById = (array, id) =>
    array.find((item) => item.id.toString() === id);

  useEffect(() => {
    dispatch(getProvinces());
    dispatch(getContraceptions());
  }, [dispatch]);

  return (
    <>
      <button>
        <Link to="/">Kembali</Link>
      </button>
      <form>
        <div>
          <label>Id Propinsi</label>
          <input
            list="provinces"
            value={provinceId}
            onChange={(e) => setProvinceId(e.target.value)}
            autoComplete="new-password"
          />
          <span>
            {isLoadingProvinces
              ? "Memuat..."
              : provincesError
              ? "Gagal memuat"
              : findById(provinces, provinceId)?.name}
          </span>
        </div>

        <div>
          <label>Id Kontrasepsi</label>
          <input
            list="contraceptions"
            value={contraceptionId}
            onChange={(e) => setContraceptionId(e.target.value)}
            autoComplete="new-password"
          />
          <span>
            {isLoadingContraceptions
              ? "Memuat..."
              : contraceptionsError
              ? "Gagal memuat"
              : findById(contraceptions, contraceptionId)?.name}
          </span>
        </div>

        <div>
          <label>Jumlah Pengguna</label>
          <input
            type="number"
            value={usageCount}
            onChange={(e) => setUsageCount(e.target.value)}
          />
        </div>

        <button type="button" onClick={submit} disabled={isSaving}>
          {isSaving ? "Menyimpan..." : "Simpan"}
        </button>
        <span>{saveMessage?.message}</span>
      </form>
      <datalist id="provinces">
        {provinces.map((province) => (
          <option key={province.id} value={province.id}>
            {province.name}
          </option>
        ))}
      </datalist>
      <datalist id="contraceptions">
        {contraceptions.map((contraception) => (
          <option key={contraception.id} value={contraception.id}>
            {contraception.name}
          </option>
        ))}
      </datalist>
    </>
  );
}

export default UsageEntryPage;
