package com.accesstage.hikeremissaocomprovcarga.processor;

import java.io.Serializable;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.file.transform.FieldSet;

import com.accesstage.hikeremissaocomprovcarga.dto.DetalheSegmentoPDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.DetalheSegmentoQDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.DetalheSegmentoRDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.HeaderDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.HeaderLoteDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.SantanderDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.TrailerDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.TrailerLoteDTO;
import com.accesstage.hikeremissaocomprovcarga.enums.TipoRegistroEnum;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ComprovanteProcessor implements ItemProcessor<FieldSet, SantanderDTO>, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public SantanderDTO process(FieldSet line) throws Exception {


		SantanderDTO santanderDTO = null;
		String identificacao = line.readString("tipoRegistro");

		if(identificacao.equals(TipoRegistroEnum.DETALHE_SEGMENTO_P.getCodigo())){
			identificacao = line.readString("codigoSegmentoRegDetalhe");
		}

		if(identificacao.equals(TipoRegistroEnum.HEADER.getCodigo())) {

			HeaderDTO headerDTO = new HeaderDTO();
			headerDTO.setCodigoBancoCompensacao(line.readString("codigoBancoCompensacao"));
			headerDTO.setLoteServico(line.readString("loteServico"));
			headerDTO.setTipoRegistro(line.readString("tipoRegistro"));
			headerDTO.setReservado(line.readString("reservado"));
			headerDTO.setTipoInscricaoEmpresa(line.readString("tipoInscricaoEmpresa"));
			headerDTO.setNumeroInscricaoEmpresa(line.readString("numeroInscricaoEmpresa"));
			headerDTO.setCodigoTransmissao(line.readString("codigoTransmissao"));
			headerDTO.setExclusivoCnab1(line.readString("exclusivoCnab1"));
			headerDTO.setNomeEmpresa(line.readString("nomeEmpresa"));
			headerDTO.setNomeBanco(line.readString("nomeBanco"));
			headerDTO.setExclusivoCnab2(line.readString("exclusivoCnab2"));
			headerDTO.setCodigoRemessa(line.readString("codigoRemessa"));
			headerDTO.setDataGeracaoArquivo(line.readString("dataGeracaoArquivo"));	
			headerDTO.setExclusivoCnab3(line.readString("exclusivoCnab3"));
			headerDTO.setNumeroSequencialArquivo(line.readString("numeroSequencialArquivo"));
			headerDTO.setNumeroVersaoLayoutArquivo(line.readString("numeroVersaoLayoutArquivo"));
			headerDTO.setExclusivoCnab4(line.readString("exclusivoCnab4"));
			
			String[] linha = line.getNames();
			String linhaInteira = "";
			for (int i = 0; i < linha.length; i++) {
				linhaInteira += line.readRawString(linha[i]);
			}
			headerDTO.setLinhaInteira(linhaInteira);

			return santanderDTO = headerDTO;

		}

		if (identificacao.equals(TipoRegistroEnum.HEADER_LOTE.getCodigo())) {

			HeaderLoteDTO headerLoteDTO = new HeaderLoteDTO();

			headerLoteDTO.setCodigoBancoCompensacao(line.readString("codigoBancoCompensacao"));
			headerLoteDTO.setLoteServico(line.readString("loteServico"));
			headerLoteDTO.setTipoRegistro(line.readString("tipoRegistro"));
			headerLoteDTO.setTipoOperacao(line.readString("tipoOperacao"));
			headerLoteDTO.setTipoServico(line.readString("tipoServico"));
			headerLoteDTO.setReservado(line.readString("reservado"));
			headerLoteDTO.setNumeroVersaoLayoutLote(line.readString("numeroVersaoLayoutLote"));
			headerLoteDTO.setUsoExclusiveCnab(line.readString("usoExclusiveCnab"));
			headerLoteDTO.setTipoInscricaoEmpresa(line.readString("tipoInscricaoEmpresa"));
			headerLoteDTO.setNumeroInscricaoEmpresa(line.readString("numeroInscricaoEmpresa"));
			headerLoteDTO.setNomeBeneficiario(line.readString("nomeBeneficiario"));
			headerLoteDTO.setMensagem(line.readString("mensagem"));
			headerLoteDTO.setNumeroSequencialRemessaRetorno(line.readString("numeroSequencialRemessaRetorno"));
			headerLoteDTO.setNumerodataGravacaoRemessaRetorno(line.readString("numerodataGravacaoRemessaRetorno"));
			headerLoteDTO.setUsoExclusivoCnab2(line.readString("usoExclusivoCnab2"));
			
			String[] linha = line.getNames();
			String linhaInteira = "";
			for (int i = 0; i < linha.length; i++) {
				linhaInteira += line.readRawString(linha[i]);
			}
			headerLoteDTO.setLinhaInteira(linhaInteira);			
			
			return santanderDTO = headerLoteDTO;

		}

		if (identificacao.equals(TipoRegistroEnum.DETALHE_SEGMENTO_P.getNome())) {

			DetalheSegmentoPDTO detalheSegmentoPDTO = new DetalheSegmentoPDTO();

			detalheSegmentoPDTO.setCodigoCompensacaoBanco(line.readString("codigoCompensacaoBanco"));
			detalheSegmentoPDTO.setLoteServico(line.readString("loteServico"));
			detalheSegmentoPDTO.setTipoRegistro(line.readString("tipoRegistro"));
			detalheSegmentoPDTO.setNumeroSequencialRegistroLote(line.readString("numeroSequencialRegistroLote"));
			detalheSegmentoPDTO.setCodigoSegmentoRegDetalhe(line.readString("codigoSegmentoRegDetalhe"));
			detalheSegmentoPDTO.setUsoExclusivoCnab(line.readString("usoExclusivoCnab"));
			detalheSegmentoPDTO.setCodigoMovimentoRemessa(line.readString("codigoMovimentoRemessa"));
			detalheSegmentoPDTO.setAgenciaMantenedora(line.readString("agenciaMantenedora"));
			detalheSegmentoPDTO.setDigitoVerificadorAgencia(line.readString("digitoVerificadorAgencia"));
			detalheSegmentoPDTO.setNumeroContaCorrente(line.readString("numeroContaCorrente"));
			detalheSegmentoPDTO.setDigitoNumeroContaCorrente(line.readString("digitoNumeroContaCorrente"));
			detalheSegmentoPDTO.setContaCobrancaDestinatariaFIDC(line.readString("contaCobrancaDestinatariaFIDC"));
			detalheSegmentoPDTO.setDigitoContaCobrancaDestinatariaFIDC(line.readString("digitoContaCobrancaDestinatariaFIDC"));
			detalheSegmentoPDTO.setReservado(line.readString("reservado"));
			detalheSegmentoPDTO.setIdentificacaoTituloBanco(line.readString("identificacaoTituloBanco"));
			detalheSegmentoPDTO.setTipoCobranca(line.readString("tipoCobranca"));
			detalheSegmentoPDTO.setFormaCadastro(line.readString("formaCadastro"));
			detalheSegmentoPDTO.setTipoDocumento(line.readString("tipoDocumento"));
			detalheSegmentoPDTO.setReservado2(line.readString("reservado2"));
			detalheSegmentoPDTO.setNumeroDocumentoCobranca(line.readString("numeroDocumentoCobranca"));
			detalheSegmentoPDTO.setDataVencimentoTitulo(line.readString("dataVencimentoTitulo"));
			detalheSegmentoPDTO.setValorNominalTitulo(line.readBigDecimal("valorNominalTitulo"));
			detalheSegmentoPDTO.setAgenciaEncarregadaCobranca(line.readString("agenciaEncarregadaCobranca"));
			detalheSegmentoPDTO.setDigitoAgenciaEncarregadaCobranca(line.readString("digitoAgenciaEncarregadaCobranca"));
			detalheSegmentoPDTO.setReservado3(line.readString("reservado3"));
			detalheSegmentoPDTO.setEspecieTitulo(line.readString("especieTitulo"));
			detalheSegmentoPDTO.setIdentificacaoTituloAceito(line.readString("identificacaoTituloAceito"));
			detalheSegmentoPDTO.setDataEmissaoTitulo(line.readString("dataEmissaoTitulo"));
			detalheSegmentoPDTO.setCodigoJurosMora(line.readString("codigoJurosMora"));
			detalheSegmentoPDTO.setDataJurosMora(line.readString("dataJurosMora"));
			detalheSegmentoPDTO.setJurosMoraTaxa(line.readString("jurosMoraTaxa"));
			detalheSegmentoPDTO.setCodigoDesconto(line.readString("codigoDesconto"));
			detalheSegmentoPDTO.setDataDesconto(line.readString("dataDesconto"));
			detalheSegmentoPDTO.setValorPercentualConcebido(line.readBigDecimal("valorPercentualConcebido"));
			detalheSegmentoPDTO.setValorIof(line.readBigDecimal("valorIof"));
			detalheSegmentoPDTO.setValorAbatimento(line.readBigDecimal("valorAbatimento"));
			detalheSegmentoPDTO.setIdentificacaoTituloEmpresa(line.readString("identificacaoTituloEmpresa"));
			detalheSegmentoPDTO.setCodigoProtesto(line.readString("codigoProtesto"));
			detalheSegmentoPDTO.setNumeroDiasProtesto(line.readString("numeroDiasProtesto"));
			detalheSegmentoPDTO.setCodigoBaixaDevolucao(line.readString("codigoBaixaDevolucao"));
			detalheSegmentoPDTO.setNumeroDiasBaixaDevolucao(line.readString("numeroDiasBaixaDevolucao"));
			detalheSegmentoPDTO.setCodigoMoeda(line.readString("codigoMoeda"));
			detalheSegmentoPDTO.setUsoExclusivoFebraban(line.readString("usoExclusivoFebraban"));
			detalheSegmentoPDTO.setReservado4(line.readString("reservado4"));
			
			return santanderDTO = detalheSegmentoPDTO;

		}

		if (identificacao.equals(TipoRegistroEnum.DETALHE_SEGMENTO_Q.getNome())) {

			DetalheSegmentoQDTO detalheSegmentoQDTO = new DetalheSegmentoQDTO();

			detalheSegmentoQDTO.setCodigoCompensacaoBanco(line.readString("codigoCompensacaoBanco"));
			detalheSegmentoQDTO.setLoteServico(line.readString("loteServico"));
			detalheSegmentoQDTO.setTipoRegistro(line.readString("tipoRegistro"));
			detalheSegmentoQDTO.setNumeroSequencialRegistroLote(line.readString("numeroSequencialRegistroLote"));
			detalheSegmentoQDTO.setCodigoSegmentoRegDetalhe(line.readString("codigoSegmentoRegDetalhe"));
			detalheSegmentoQDTO.setUsoExclusivoCnab(line.readString("usoExclusivoCnab"));
			detalheSegmentoQDTO.setCodigoMovimentacaoRemessa(line.readString("codigoMovimentacaoRemessa"));
			detalheSegmentoQDTO.setTipoInscricao(line.readString("tipoInscricao"));
			detalheSegmentoQDTO.setNumeroInscricao(line.readString("numeroInscricao"));
			detalheSegmentoQDTO.setNome(line.readString("nome"));
			detalheSegmentoQDTO.setEndereco(line.readString("endereco"));
			detalheSegmentoQDTO.setBairro(line.readString("bairro"));
			detalheSegmentoQDTO.setCidade(line.readString("cidade"));
			detalheSegmentoQDTO.setCep(line.readString("cep"));
			detalheSegmentoQDTO.setSufixoCep(line.readString("sufixoCep"));
			detalheSegmentoQDTO.setUnidadeFederacao(line.readString("unidadeFederacao"));
			detalheSegmentoQDTO.setTipoInscricaoSacado(line.readString("tipoInscricaoSacado"));
			detalheSegmentoQDTO.setNumeroInscricaoSacado(line.readString("numeroInscricaoSacado"));
			detalheSegmentoQDTO.setNomeSacado(line.readString("nomeSacado"));
			detalheSegmentoQDTO.setIdentificadorCarne(line.readString("identificadorCarne"));
			detalheSegmentoQDTO.setSequencialParcela(line.readString("sequencialParcela"));
			detalheSegmentoQDTO.setQuantidadeParcela(line.readString("quantidadeParcela"));
			detalheSegmentoQDTO.setNumeroPlano(line.readString("numeroPlano"));
			detalheSegmentoQDTO.setReservado(line.readString("reservado"));
			
			return santanderDTO = detalheSegmentoQDTO;
		}

		if (identificacao.equals(TipoRegistroEnum.DETALHE_SEGMENTO_R.getNome())) {
			
			DetalheSegmentoRDTO detalheSegmentoRDTO = new DetalheSegmentoRDTO();
			
			detalheSegmentoRDTO.setCodigoCompensacaoBanco(line.readString("codigoCompensacaoBanco"));
			detalheSegmentoRDTO.setLoteServico(line.readString("loteServico"));
			detalheSegmentoRDTO.setTipoRegistro(line.readString("tipoRegistro"));
			detalheSegmentoRDTO.setNumeroSequencialRegistroLote(line.readString("numeroSequencialRegistroLote"));
			detalheSegmentoRDTO.setCodigoSegmentoRegDetalhe(line.readString("codigoSegmentoRegDetalhe"));
			detalheSegmentoRDTO.setUsoExclusivoCnab(line.readString("usoExclusivoCnab"));
			detalheSegmentoRDTO.setCodigoMovimentacaoRemessa(line.readString("codigoMovimentacaoRemessa"));
			detalheSegmentoRDTO.setCodigoDesconto(line.readString("codigoDesconto"));
			detalheSegmentoRDTO.setDataDesconto(line.readString("dataDesconto"));
			detalheSegmentoRDTO.setValorPercentualConcedido(line.readString("valorPercentualConcedido"));
			detalheSegmentoRDTO.setReservado2(line.readString("reservado2"));
			detalheSegmentoRDTO.setCodigoMulta(line.readString("codigoMulta"));
			detalheSegmentoRDTO.setDataMulta(line.readString("dataMulta"));
			detalheSegmentoRDTO.setValorPercentualAplicado(line.readString("valorPercentualAplicado"));
			detalheSegmentoRDTO.setReservado3(line.readString("reservado3"));
			detalheSegmentoRDTO.setMensagem(line.readString("mensagem"));
			detalheSegmentoRDTO.setReservado4(line.readString("reservado4"));			
			
		}
		
		if (identificacao.equals(TipoRegistroEnum.TRAILER_LOTE.getCodigo())) {

			TrailerLoteDTO trailerLoteDTO = new TrailerLoteDTO();
			trailerLoteDTO.setCodigoCompensacaoBanco(line.readString("codigoCompensacaoBanco"));
			trailerLoteDTO.setLoteServico(line.readString("loteServico"));
			trailerLoteDTO.setTipoRegistro(line.readString("tipoRegistro"));
			trailerLoteDTO.setUsoExclusivoCnab(line.readString("usoExclusivoCnab"));
			trailerLoteDTO.setQuantidadeRegistroLote(line.readString("quantidadeRegistroLote"));
			trailerLoteDTO.setQtdTitulosCobrados(line.readString("qtdTitulosCobrados"));
			trailerLoteDTO.setValorTotalTituloCarteiraSimples(line.readString("valorTotalTituloCarteiraSimples"));
			trailerLoteDTO.setQtdTitulosCobranca(line.readString("qtdTitulosCobranca"));
			trailerLoteDTO.setValorTotalTitulosCarteiraVinculada(line.readBigDecimal("valorTotalTitulosCarteiraVinculada"));
			trailerLoteDTO.setQtdTitulosCobrancaCaucionada(line.readString("qtdTitulosCobrancaCaucionada"));
			trailerLoteDTO.setValorTotalTituloCarteiraCaucionada(line.readBigDecimal("valorTotalTituloCarteiraCaucionada"));
			trailerLoteDTO.setQtdTitulosCobrancaDescontada(line.readString("qtdTitulosCobrancaDescontada"));
			trailerLoteDTO.setValorTotalTituloCarteiraDescontada(line.readBigDecimal("valorTotalTituloCarteiraDescontada"));
			trailerLoteDTO.setNumeroAviso(line.readString("numeroAviso"));
			trailerLoteDTO.setUsoExclusivoCnab2(line.readString("usoExclusivoCnab2"));
			
			String[] linha = line.getNames();
			String linhaInteira = "";
			for (int i = 0; i < linha.length; i++) {
				linhaInteira += line.readRawString(linha[i]);
			}
			trailerLoteDTO.setLinhaInteira(linhaInteira);
			return santanderDTO = trailerLoteDTO;		
		}

		if (identificacao.equals(TipoRegistroEnum.TRAILER.getCodigo())) {

			TrailerDTO trailerDTO = new TrailerDTO();
			trailerDTO.setCodigoCompensacaoBanco(line.readString("codigoCompensacaoBanco"));
			trailerDTO.setLoteServico(line.readString("loteServico"));
			trailerDTO.setTipoRegistro(line.readString("tipoRegistro"));
			trailerDTO.setUsoExclusivoCnab(line.readString("usoExclusivoCnab"));
			trailerDTO.setQuantidadeLotesArquivo(line.readString("quantidadeLotesArquivo"));
			trailerDTO.setQuantidadeRegistrosArquivo(line.readString("quantidadeRegistrosArquivo"));
			trailerDTO.setQuantidadeContasLote(line.readString("quantidadeContasLote"));
			trailerDTO.setUsoExclusivoCnab2(line.readString("usoExclusivoCnab2"));			
			
			String[] linha = line.getNames();
			String linhaInteira = ""; 
			for (int i = 0; i < linha.length; i++) {	
				linhaInteira += line.readRawString(linha[i]);
			}
			trailerDTO.setLinhaInteira(linhaInteira);
			return santanderDTO = trailerDTO;
			
		}
		return santanderDTO;
	}
}
