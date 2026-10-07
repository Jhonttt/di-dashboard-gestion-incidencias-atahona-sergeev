# Utilidades de presentación compartidas por los hooks.
# No es un hook: los hooks lo importan con ". lib/ui.sh".

# ── Colores (solo si la salida es una terminal) ─────────────
if [ -t 2 ] && [ -z "$NO_COLOR" ]; then
  UI_TTY=1
  RED=$(printf '\033[31m'); GREEN=$(printf '\033[32m'); YELLOW=$(printf '\033[33m')
  CYAN=$(printf '\033[36m'); BOLD=$(printf '\033[1m'); DIM=$(printf '\033[2m')
  RESET=$(printf '\033[0m'); CLEAR=$(printf '\033[K')
  BADGE=$(printf '\033[1;30;46m')       # negrita, texto negro, fondo cian
  BADGE_OK=$(printf '\033[1;30;42m')    # negrita, texto negro, fondo verde
  HIDE_CURSOR=$(printf '\033[?25l'); SHOW_CURSOR=$(printf '\033[?25h')
else
  UI_TTY=
  RED=; GREEN=; YELLOW=; CYAN=; BOLD=; DIM=; RESET=; CLEAR=
  BADGE=; BADGE_OK=; HIDE_CURSOR=; SHOW_CURSOR=
fi

# ── Ajustes ────────────────────────────────────────────────
FRAMES='⠋ ⠙ ⠹ ⠸ ⠼ ⠴ ⠦ ⠧ ⠇ ⠏'
COL=26   # ancho de la columna de nombres

# ── Tiempo ──────────────────────────────────────────────────
now_ms() { date +%s%3N; }                                   # milisegundos
fmt_ms() { awk -v ms="$1" 'BEGIN { printf "%.1fs", ms / 1000 }'; }

# ── Elementos ───────────────────────────────────────────────
header() {
  printf '\n%s CALIDAD %s %s%s%s\n\n' "$BADGE" "$RESET" "$BOLD" "$1" "$RESET" >&2
}

# spin PID "Nombre": anima mientras el proceso PID siga vivo
spin() {
  [ -n "$UI_TTY" ] || return 0
  printf '%s' "$HIDE_CURSOR" >&2
  while kill -0 "$1" 2>/dev/null; do
    for F in $FRAMES; do
      kill -0 "$1" 2>/dev/null || break
      printf '\r  %s%-*s%s%s%s' "$DIM" "$COL" "$2" "$CYAN" "$F" "$RESET" >&2
      sleep 0.08
    done
  done
}

# ok_line / fail_line / skip_line "Nombre" "detalle"
ok_line() {
  printf '\r  %s%-*s✔%s  %s%s%s%s\n' "$GREEN" "$COL" "$1" "$RESET" "$DIM" "$2" "$RESET" "$CLEAR" >&2
}
fail_line() {
  printf '\r  %s%-*s✖%s  %s%s%s%s\n' "$RED" "$COL" "$1" "$RESET" "$DIM" "$2" "$RESET" "$CLEAR" >&2
}
skip_line() {
  printf '\r  %s%-*s–  %s%s%s\n' "$DIM" "$COL" "$1" "$2" "$RESET" "$CLEAR" >&2
}