let assert = require("assert");
let disciplina = require("./scoord2").disciplina;
let turma = require("./scoord2").turma;
let professor = require("./scoord2").professor;
let estudante = require("./scoord2").estudante;

describe("factory Disciplina", function () {
    let d0;

    before(async () => {
        d0 = new disciplina("prog1", "Programação 1", 4, []);
    });

    it("deve criar disciplinas distintas a cada invocação", function () {
        d0 = new disciplina("prog1", "Programação 1", 4, []);
        d1 = new disciplina("prog2", "Programação 2", 4, []);
        d2 = new disciplina("Atal", "Analise e tecnica de algoritmos", 4, []);
        assert.notEqual(d0, d1);
        assert.notEqual(d0, d2);
        assert.notEqual(d1, d2);
    });

    it("deve reter os dados de inicialização", function () {
        assert.equal("prog1", d0.id());
        assert.equal("Programação 1", d0.get_nome());
        assert.equal(4, d0.creditos);
        assert.deepEqual([], d0.pre_requisitos);
    });

    it("deve permitir atualização de nome", function () {
        d0.set_nome("Programação de Computadores I");
        assert.equal("prog1", d0.id());
        assert.equal("Programação de Computadores I", d0.get_nome());
        assert.deepEqual([], d0.pre_requisitos);
    });

    it("nÃ£o deve permitir atualização de id via set_id", function () {
        assert.throws(function () {
            d0.set_id("outro");
        }, TypeError);
        assert.equal("prog1", d0.id());
    });
});

describe("factory Turma", function () {
    let t0;

    before(async () => {
        d0 = new disciplina("prog1", "Programação 1", 4, []);
        t0 = new turma(d0, "4");
    });

    it("deve criar turmas distintas a cada invocação", function () {
        d0 = new disciplina("prog1", "Programação 1", 4, []);
        d1 = new disciplina("prog2", "Programação 2", 4, []);
        d2 = new disciplina("Atal", "Analise e tecnica de algoritmos", 4, []);
        t1 = new turma(d1, "2");
        t2 = new turma(d2, "5");
        assert.notEqual(t0, t1);
        assert.notEqual(t0, t2);
        assert.notEqual(t1, t2);
    });

    it("deve reter os dados de inicialização", function () {
        assert.deepEqual(JSON.stringify(t0.get_disciplina()), JSON.stringify(d0));
        assert.equal(t0.get_periodo(), "4");
    });

    it("deve permitir atualização de professor", function () {
        t0.set_professor("dalton");
        assert.equal(t0.get_professor(), "dalton");
    });

    it("deve permitir atualização de estudantes", function () {
        t0.matricular("larissa");
        t0.matricular("chiva");
        assert.deepEqual(t0.get_estudantes(), ["larissa", "chiva"]);
    });

    it("deve permitir atualização de status", function () {
        t0.set_status("planejada");
        assert.equal(t0.get_status(), "planejada");
    });
});

describe("factory Professor", function () {
    let p0;

    before(async () => {
        p0 = professor(
            "096110400",
            "Dalton Serey",
            "dalton@computacao.edu.br",
            "60245559429",
            "https://pbs.twimg.com/profile_images/930005068/dalton2-pb_400x400.jpg"
        );
    });

    it("deve criar professores distintos a cada invocação", function () {
        p0 = professor(
            "096110400",
            "Dalton Serey",
            "dalton@computacao.edu.br",
            "60245559429",
            "https://pbs.twimg.com/profile_images/930005068/dalton2-pb_400x400.jpg"
        );
        p1 = professor(
            "020110402",
            "Raquel Vigolvino",
            "raquel@computacao.edu.br",
            "60245884425",
            "https://avatars1.githubusercontent.com/u/3511778?s=180&v=4"
        );
        p2 = professor(
            "020120462",
            "Matheus Gaudencio",
            "matheus@computacao.edu.br",
            "39504669505",
            "https://pbs.twimg.com/profile_images/1156528346894872582/vUAGA_V2_400x400.jpg"
        );
        assert.notEqual(p0, p1);
        assert.notEqual(p0, p2);
        assert.notEqual(p1, p2);
    });

    it("deve reter os dados de inicialização", function () {
        assert.equal(p0.get_matricula(), "096110400");
        assert.equal(p0.get_nome(), "Dalton Serey");
        assert.equal(p0.get_email(), "dalton@computacao.edu.br");
        assert.equal(p0.get_cpf(), "60245559429");
        assert.equal(
            p0.get_url(),
            "https://pbs.twimg.com/profile_images/930005068/dalton2-pb_400x400.jpg"
        );
    });

    it("deve permitir alocar turmas ao professor", function () {
        d0 = disciplina("prog1", "Programação 1", 4, []);
        d1 = disciplina("prog2", "Programação 2", 4, []);
        t0 = turma(d0, "4");
        t1 = turma(d1, "4");
        p0.aloca_turma(t0);
        p0.aloca_turma(t1);
        assert.deepEqual(p0.turmas("4"), [t0, t1]);
    });

    it("deve permitir atualização do email", function () {
        p0.set_email("dalton@ccc.ufcg.edu.br");
        assert.deepEqual(p0.get_email(), "dalton@ccc.ufcg.edu.br");
    });

    it("deve permitir atualização da url da foto", function () {
        p0.set_url(
            "https://csdl-images.computer.org/mags/so/2010/04/figures/mso2010040052x3.gif"
        );
        assert.deepEqual(
            p0.get_url(),
            "https://csdl-images.computer.org/mags/so/2010/04/figures/mso2010040052x3.gif"
        );
    });
});

describe("factory Estudante", function () {
    let e0;

    before(async () => {
        e0 = estudante(
            "096110400",
            "Lucio Nathan",
            "lucion@computacao.edu.br",
            "60245559429",
            "https://pbs.twimg.com/profile_images/930005068/dalton2-pb_400x400.jpg"
        );
    });

    it("deve criar estudantes distintos a cada invocação", function () {
        e0 = professor(
            "096110400",
            "Lucio Nathan",
            "lucion@computacao.edu.br",
            "60245559429",
            "https://avatars3.githubusercontent.com/u/42965703?s=400&v=4"
        );
        e1 = professor(
            "020110402",
            "Higor Santos",
            "higors@computacao.edu.br",
            "60245884425",
            "https://avatars3.githubusercontent.com/u/40602956?s=460&v=4"
        );
        e2 = professor(
            "020120462",
            "Gabriel Nobrega",
            "gabrieln@computacao.edu.br",
            "39504669505",
            "https://avatars2.githubusercontent.com/u/39278738?s=460&v=4"
        );
        assert.notEqual(e0, e1);
        assert.notEqual(e0, e2);
        assert.notEqual(e1, e2);
    });

    it("deve reter os dados de inicialização", function () {
        assert.equal(e0.get_matricula(), "096110400");
        assert.equal(e0.get_nome(), "Lucio Nathan");
        assert.equal(e0.get_email(), "lucion@computacao.edu.br");
        assert.equal(e0.get_cpf(), "60245559429");
        assert.equal(
            e0.get_url(),
            "https://avatars3.githubusercontent.com/u/42965703?s=400&v=4"
        );
    });

    it("deve permitir alocar turmas ao estudante", function () {
        d0 = disciplina("prog1", "Programação 1", 4, []);
        d1 = disciplina("prog2", "Programação 2", 4, []);
        t0 = turma(e0, "4");
        t1 = turma(e1, "4");
        e0.aloca_turma(t0);
        e0.aloca_turma(t1);
        assert.deepEqual(e0.turmas("4"), [t0, t1]);
    });

    it("deve permitir atualização do email", function () {
        e0.set_email("lucionathan@hotmail.com");
        assert.deepEqual(e0.get_email(), "lucionathan@hotmail.com");
    });

    it("deve permitir atualização da url da foto", function () {
        e0.set_url(
            "https://scontent.fjdo1-2.fna.fbcdn.net/v/t1.0-9/69273228_774273736323876_4014937373920985088_n.jpg?_nc_cat=106&_nc_oc=AQnOlpEPS7o-GCyy_Fes7L__1QQO80pqP1k5r2TR7ZjMTKZMAEZwXIFY7X57pnX0mbg&_nc_ht=scontent.fjdo1-2.fna&oh=cb2637268d8347954437ae5c50c5566e&oe=5E6053C4"
        );
        assert.deepEqual(
            e0.get_url(),
            "https://scontent.fjdo1-2.fna.fbcdn.net/v/t1.0-9/69273228_774273736323876_4014937373920985088_n.jpg?_nc_cat=106&_nc_oc=AQnOlpEPS7o-GCyy_Fes7L__1QQO80pqP1k5r2TR7ZjMTKZMAEZwXIFY7X57pnX0mbg&_nc_ht=scontent.fjdo1-2.fna&oh=cb2637268d8347954437ae5c50c5566e&oe=5E6053C4"
        );
    });
});
