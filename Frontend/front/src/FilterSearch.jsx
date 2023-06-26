import React from "react";

const FilterSearch = ({ filter, setFilter, handleSubmit }) => {
    return (
        <div className="search">
            <form onSubmit={handleSubmit}>
                <input type="text" placeholder="Digite..." onChange={(e) => {setFilter(e.target.value)}}></input>
                <button type="submit">Buscar</button>
            </form>
        </div>
    )
};

export default FilterSearch;