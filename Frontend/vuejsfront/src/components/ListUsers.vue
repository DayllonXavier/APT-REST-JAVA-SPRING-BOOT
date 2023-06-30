<template>
    <table className="listUsers">
        <thead><tr>
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
            <tr v-for="user in users" :key="user.codigo">
                <td>{{user.nomeCompleto}}</td>
                <td>{{user.nomeSocial}}</td>
                <td>{{user.dataDeNascimento}}</td>
                <td>{{user.sexo}}</td>
                <td>{{user.email}}</td>
                <td>{{user.estado}}</td>
                <td>{{user.municipio}}</td>
                <td>{{user.numeroDeAcessos}}</td>
                <td>{{user.situacao}}</td>
                <td>{{user.dataDeVinculo}}</td>
            </tr>
        </tbody>
    </table>
</template>

<script>
export default {
    name: 'ListUsers',
    props: {
        users: Object
    }
}
</script>