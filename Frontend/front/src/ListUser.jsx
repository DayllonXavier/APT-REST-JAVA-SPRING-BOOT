import React from "react";

const ListUser = ({users, setUsers}) => {
    return (
        <table className="listUser">
            <thead><tr>
                {//<th>Código</th>
                }
                <th>Nome Completo</th>
                <th>Nome Social</th>
                <th>Data de Nascimento</th>
                <th>Sexo</th>
                <th>Email</th>
                <th>Estado</th>
                <th>Município</th>
                <th>Número de Acessos</th>
                <th>Situação</th>
                <th>Data de Vínculo</th>
            </tr></thead>
            <tbody>
            {
                users.map(user => {
                    return (
                        <tr>
                            {//<td>{user.codigo}</td>
                            }
                            <td>{user.nomeCompleto}</td>
                            <td>{user.nomeSocial}</td>
                            <td>{user.dataDeNascimento}</td>
                            <td>{user.sexo}</td>
                            <td>{user.email}</td>
                            <td>{user.estado}</td>
                            <td>{user.municipio}</td>
                            <td>{user.numeroDeAcessos}</td>
                            <td>{user.situacao}</td>
                            <td>{user.dataDeVinculo}</td>
                        </tr>
                    )
                })
            }
            </tbody>
        </table>
    )
    /*return (
        users.map(user => {
            return (
                <h1>{user.nomeCompleto}</h1>
            )
        })
    )*/
};

export default ListUser;