package htw.gruppe.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

/**
 * Entitaet fur Ausage
 * @author Tabatt
 */

    @Entity
    @Table(name="aussage")
    public class Aussage {
    /**
     * primary key ist id, nicht auto generated.
     * columns aussage_id, aussage_text und aktive sind vorhanden"
     */
        @Id
        @Column(name = "aussage_id")
        private Long id;

        @Column(name = "aussage_text")
        private String aussage_text;

        @Column(name = "aktiv")
        private Boolean aktiv;
    /**
     * Eine Aussage kann viele Kandidaten Antworten haben durch one to many
     * Parent ist Aussage und Kind ist Kandidaten Antwort.
     * Alle Antworten ohne aussage werden geloescht.
     *
     */
        @OneToMany(mappedBy = "aussage", cascade = CascadeType.ALL, orphanRemoval = true)
        //@JsonManagedReference("aussage_id")

        private List<KandidatenAntwort> kandidatenAntworten;

        
        public Aussage() {}

        public Aussage(Long id, String aussage_text, Boolean aktiv) {
           this.id = id;
            this.aussage_text = aussage_text;
            this.aktiv = aktiv;
        }

        public Long getId() {

            return this.id;
        }

        public String getAussage_text() {
            return this.aussage_text;
        }

        public Boolean getAktiv() {
            return this.aktiv;
        }

        public void setAktiv(Boolean aktiv) {
            this.aktiv = aktiv;
        }

    /**
     *
     * @param o   the reference object with which to compare.
     * @return

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Aussage aussage)) return false;
            return Objects.equals(id, aussage.id) && Objects.equals(aussage_text, aussage.aussage_text) && Objects.equals(aktiv, aussage.aktiv);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.id, this.aussage_text, this.aktiv);
        }
     */
    /**
     *
     * @return

        @Override
        public String toString() {
            return "Aussage{" +
                    "id=" + id +
                    ", aussage_text='" + aussage_text + '\'' +
                    ", aktiv=" + aktiv +
                    '}';
        }  */
    }

