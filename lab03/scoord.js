function disciplinas(id, nome, creditos, pre){
    let _id = id;
    let disciplina = {
        id: function(){
            return _id;
        },
        get_nome: function (){
            return this.nome;
        },
        set_nome: function(nome){
            this.nome = nome;
        }
    }
    disciplina.nome = nome;
    disciplina.creditos = creditos;
    disciplina.pre_requisitos = pre;

    return disciplina;
}

function turma(disciplina, periodo){
    let _disc = disciplina
    let _periodo = periodo
    let turma = {
        get_disciplina: () => _disc,
        get_periodo: () => _periodo,
        professor: null,
        estudantes: [],
        status: undefined,
        set_status: (new_status) => {
            if(new_status !== "planejada" || new_status !== "ativa" || new_status !== "concluída"){
                console.log("Status Inválido")
            }else{
                this.status = new_status;
            }
        },
        matricular: (matricula) => {
            if(!this.estudantes.includes(matricula)){
                this.estudantes.push(matricula)
            }
        }
    }
    return turma
}

function estudante(matricula, nome, email, cpf, url){
    let _matricula = matricula
    let _nome = nome
    let _email = email
    let _cpf = cpf
    let _url = url

    let estudante = {
        turmasMatriculadas: [],
        get_matricula: () => _matricula,
        get_nome: () => _nome,
        get_cpf: () => _cpf,
        get_email: () => _email,
        get_cpf: () => _cpf,
        get_url: () => _url,
        set_nome: (nome) => _nome = nome,
        matricula: (turma) => this.turmasMatriculadas.push(turma),
        turmas: (semestre) => {
            let retorno = [];
            this.turmasMatriculadas.forEach(turma => {
                if(turma.get_periodo === semestre){
                    retorno.push(turma)
                }
            });
            return retorno;
        }
    }
    return estudante;
}

module.exports = {
    disciplina: disciplinas,
    turma,
    estudante

}